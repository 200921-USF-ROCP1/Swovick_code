package com.revature.bankAPI.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.bankAPI.helpers.AccountTransfer;
import com.revature.bankAPI.helpers.JsonString;
import com.revature.bankAPI.helpers.StringUtils;
import com.revature.bankAPI.models.Account;
import com.revature.bankAPI.models.User;
import com.revature.bankAPI.services.AccountServices;
import com.revature.bankAPI.services.AdminServices;
import com.revature.bankAPI.services.EmployeeServices;
import com.revature.bankAPI.services.UserServices;

/**
 * Servlet implementation class AccountServlet
 */
public class AccountServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;
    
    /*public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }*/
	private EmployeeServices empServices;
    private AdminServices adminServices;
    private UserServices userServices;
    private AccountServices accountServices;
    private JsonString jsonStr;
    public AccountServlet() {
    	//super();
    	empServices = new EmployeeServices();
    	adminServices = new AdminServices();
    	userServices = new UserServices();
    	accountServices = new AccountServices();
    	jsonStr = new JsonString();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String[] parts = path.split("/");
		HttpSession session = request.getSession();
		User currUser = (User) session.getAttribute("CurrUser");
		//JsonString jsonStr = new JsonString();
		//empServices = new EmployeeServices(currUser);
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		if(currUser!=null) {
			boolean isAdmin = adminServices.isAdmin(currUser);
			boolean isEmployee = empServices.isEmployee(currUser);
			if(parts.length==3) {
				if(isAdmin || isEmployee) {
					List<Account> accounts = accountServices.getAllAccounts();
					pw.println(mapper.writeValueAsString(accounts));
				}
				else {
					response.setStatus(401);
					jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
				}
			}
			else if(parts.length==4) {
				if(StringUtils.isInteger(parts[3])) {
					int accntId = Integer.parseInt(parts[3]);
					Account currAccount = accountServices.getAccountById(accntId);
					User accntUser = currAccount.getUser();
					int accntUserId = accntUser.getUserId();
					if(isAdmin||isEmployee|| userServices.isCurrUser(currUser, accntUserId)) {
						response.setStatus(200);
						pw.println(mapper.writeValueAsString(currAccount));
					}
					else {
						response.setStatus(401);
						jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
					}
				}
				else {
					response.sendError(404);
				}
			}
			else if(parts.length==5) {
				if(StringUtils.isInteger(parts[4])) {
					switch (parts[3]) {
						case "owner":
							int userId = Integer.parseInt(parts[4]);
							if(isAdmin || isEmployee || userServices.isCurrUser(currUser, userId)) {
								List<Account> userAccounts = accountServices.getAccountsByUser(userId);
								response.setStatus(200);
								pw.println(mapper.writeValueAsString(userAccounts));
							}
							else {
								jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
							}
							break;
						case "status":
							int statusId = Integer.parseInt(parts[4]);
							if(isAdmin || isEmployee) {
								List<Account> statusAccounts = accountServices.getAccountsByStatus(statusId);
								response.setStatus(200);
								pw.println(mapper.writeValueAsString(statusAccounts));
							}
							else {
								jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
							}
							break;
						default:
							response.sendError(404);
							break;
					}
				}
				else {
					response.sendError(404);
				}
			}
			else {
				response.sendError(404);
			}
		}
		else {
			response.setStatus(400);
			jsonStr.printMessage(pw, mapper, "There was no user logged into the session");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String[] parts = path.split("/");
		HttpSession session = request.getSession();
		User currUser = (User) session.getAttribute("CurrUser");
		//JsonString jsonStr = new JsonString();
		//empServices = new EmployeeServices(currUser);
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		if(currUser!=null) {
			boolean isAdmin = adminServices.isAdmin(currUser);
			boolean isEmployee = empServices.isEmployee(currUser);
			if(parts.length==3) {
				Account account = mapper.readValue(request.getReader(), Account.class);
				int accountUserId = account.getUser().getUserId();
				if(isAdmin || isEmployee || userServices.isCurrUser(currUser, accountUserId)) {
					accountServices.createAccount(account);
					response.setStatus(201);
					pw.println(mapper.writeValueAsString(account));
				}
				else {
					//Invalid credentials
					response.setStatus(401);
					jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
				}
			}
			else if(parts.length==4) {
				switch(parts[3]) {
					case "deposit":
						Account idAndDeposit = mapper.readValue(request.getReader(), Account.class);
						Account toDeposit = accountServices.getAccountById(idAndDeposit.getAccountId());
						if(toDeposit!=null) {
							int userDepositId = toDeposit.getUser().getUserId();
							if(isAdmin || userServices.isCurrUser(currUser, userDepositId)) {
								double deposit = idAndDeposit.getBalance();
								accountServices.deposit(deposit, toDeposit);
								response.setStatus(200);
								String message = "$" + deposit + " has been deposited to Account #" + toDeposit.getAccountId();
								jsonStr.printMessage(pw, mapper, message);
							}
							else {
								response.setStatus(401);
								jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
							}
						}
						else {
							response.setStatus(400);
							jsonStr.printMessage(pw, mapper, "The account you are depositing to does not exist");
						}
					break;
					case "withdraw":
						Account idAndWithdraw = mapper.readValue(request.getReader(), Account.class);
						Account toWithdraw = accountServices.getAccountById(idAndWithdraw.getAccountId());
						if(toWithdraw!=null) {
							int userWithdrawId = toWithdraw.getUser().getUserId();
							if(isAdmin || userServices.isCurrUser(currUser, userWithdrawId)) {
								double withdraw = idAndWithdraw.getBalance();
								try {
									accountServices.withdraw(withdraw, toWithdraw);
									response.setStatus(200);
									String message = "$" + withdraw + " has been withdrawn from Account #" + toWithdraw.getAccountId();
									jsonStr.printMessage(pw, mapper, message);
								} catch (Exception e) {
									response.setStatus(400);
									jsonStr.printMessage(pw, mapper, "Withdrawal larger than the current balance");
								}
							}
							else {
								response.setStatus(401);
								jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
							}
						}
						else {
							response.setStatus(400);
							jsonStr.printMessage(pw, mapper, "The account you are depositing to does not exist");
						}
					break;
					case "transfer":
						AccountTransfer accountTransfer = mapper.readValue(request.getReader(), AccountTransfer.class);
						Account toTransferFrom = accountServices.getAccountById(accountTransfer.getSourceAccountId());
						Account toTransferTo = accountServices.getAccountById(accountTransfer.getTargetAccountId());
						if(toTransferFrom!=null && toTransferTo!=null) {
							int userTransferId = toTransferFrom.getUser().getUserId();
							if(isAdmin || userServices.isCurrUser(currUser, userTransferId)) {
								double transferAmount = accountTransfer.getAmount();
								try {
									accountServices.transfer(transferAmount, toTransferFrom, toTransferTo);
									response.setStatus(200);
									String message = "$" + transferAmount + " has been transferred from Account #" 
											+ toTransferFrom.getAccountId() + " to Account #" + toTransferTo.getAccountId();
									jsonStr.printMessage(pw, mapper, message);
								} catch (Exception e) {
									response.setStatus(400);
									jsonStr.printMessage(pw, mapper, "Withdrawal from source account larger than current balance");
								}
							}
							else {
								response.setStatus(401);
								jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
							}
						}
						else {
							response.setStatus(400);
							jsonStr.printMessage(pw, mapper, "The account(s) you are transferring between to does not exist");
						}
					break;
				}
			}
		}
		else {
			response.setStatus(400);
			jsonStr.printMessage(pw, mapper, "There was no user logged into the session");
		}
	}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getRequestURI();
		String[] parts = path.split("/");
		HttpSession session = request.getSession();
		User currUser = (User) session.getAttribute("CurrUser");
		//JsonString jsonStr = new JsonString();
		//empServices = new EmployeeServices(currUser);
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		if(currUser!=null) {
			boolean isAdmin = adminServices.isAdmin(currUser);
			if(parts.length==3) {
				Account account = mapper.readValue(request.getReader(), Account.class);
				//int accountUserId = account.getUser().getUserId();
				if(isAdmin) {
					accountServices.updateAccount(account);
					response.setStatus(200);
					pw.println(mapper.writeValueAsString(account));
				}
				else {
					//Invalid credentials
					response.setStatus(401);
					jsonStr.printMessage(pw, mapper, "The requested action is not permitted");
				}
			}
			else {
				response.sendError(404);
			}
		}
		else {
			response.setStatus(400);
			jsonStr.printMessage(pw, mapper, "There was no user logged into the session");
		}
	}
}
