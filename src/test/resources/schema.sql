
CREATE TABLE IF NOT EXISTS "USERS" (
                         ID VARCHAR(40) PRIMARY KEY,
                         EMAIL VARCHAR(200),
                         PASSWORD VARCHAR(300)
);


CREATE TABLE IF NOT EXISTS "EVENTS" (
                         ID VARCHAR(40) PRIMARY KEY,
                         DATE VARCHAR(20),
                         DESCRIPTION VARCHAR(400),
                         IMAGE VARCHAR(1000),
                         TITLE VARCHAR(30)
);

