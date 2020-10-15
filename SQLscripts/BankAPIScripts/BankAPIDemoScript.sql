select * from users;
select * from accounts;
select * from accounts join users_accounts ua on 
accounts.account_id = ua.account_id join users on 
users.user_id = ua.user_id;