# usernamelistapp
usernamelist problem solution app
--this is spring/Java  solution  for Username List Problem

-- I use hsql db engine as storage area it is small db engine with in-memory and disk-based tables 
-- table created one for usernames taken 'user' table
-- and restricted names 'restrictednames' table  and you can add to it if you want by use restricted page.

--run http://localhost:8080/UsernameListAppSpring/login for test username exist/new/restricted
-- run http://localhost:8080/UsernameListAppSpring/restricted to add new restriected username.

-- Tomcat 8.0 is used for deploy
-- Spring framework is used to wire dependencies 
-- Junit to test is used

-- if username length < 6 validation message error appear
-- if username already exists validation message error appear and suggesstion list 
-- if username already exists in restricted list validation message appear and suggesstion list 
-- if username is valid welcome message appear 

-- use TestUsernameList to test solution 

-- in next update I will optimize the view and the structure.

