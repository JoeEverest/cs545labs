INSERT INTO roles (role) 
SELECT 'ROLE_USER' 
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE role = 'ROLE_USER');

INSERT INTO roles (role) 
SELECT 'ROLE_ADMIN' 
WHERE NOT EXISTS (SELECT 1 FROM roles WHERE role = 'ROLE_ADMIN');