INSERT INTO apartments (building_letter, room_number, monthly_rent) VALUES
  ('A', 1, 1250),
  ('B', 1, 1300),
  ('C', 1, 1500),
  ('C', 2, 1400);

INSERT INTO residents (first_name, last_name, apartment_id) values
  ('Jacob', 'Davis', 1),
  ('Sally', 'Bobson', 2),
  ('Ricky', 'Bobson', 2),
  ('Martha', 'Stuart', 3),
  ('Jackie', 'Samson', 4);

INSERT INTO cars (make, model, year, license_plate, owner_id) values 
  ('Toyota', 'Corolla', 1995, 'IGB18SS', 2),
  ('Honda', 'Civic', 2001, 'FFGB91S', 3);

INSERT INTO pets (breed, name, apartment_id, is_service_animal) VALUES
  ('cat', 'Jimmy', 3, true),
  ('dog', 'Spot', 4, false);

select * from residents;
select * from apartments;

select residents.*, building_letter from residents 
join apartments on residents.apartment_id = apartments.id
where Apartments.building_letter = 'B';

select avg(monthly_rent) from apartments
where building_letter = 'C';

select count(id) from pets;

select residents.*, pets.name from residents 
join apartments on residents.apartment_id = apartments.id 
join pets on apartments.id = pets.apartment_id
where pets.name='Spot';

select cars.make, residents.first_name, residents. last_name from cars 
join residents on residents.id = cars.owner_id
where residents.first_name = 'Sally'
and residents.last_name = 'Bobson'


