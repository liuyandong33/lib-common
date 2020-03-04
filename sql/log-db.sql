CREATE DATABASE `zd1-catering-log-db`;
DROP TABLE IF EXISTS logging_event;
CREATE TABLE logging_event
(
    timestmp BIGINT NOT NULL,
    formatted_message TEXT NOT NULL,
    logger_name VARCHAR(255) NOT NULL,
    level_string VARCHAR(255) NOT NULL,
    thread_name VARCHAR(255),
    reference_flag SMALLINT,
    arg0 VARCHAR(255),
    arg1 VARCHAR(255),
    arg2 VARCHAR(255),
    arg3 VARCHAR(255),
    caller_filename VARCHAR(255) NOT NULL,
    caller_class VARCHAR(255) NOT NULL,
    caller_method VARCHAR(255) NOT NULL,
    caller_line CHAR(4) NOT NULL,
    event_id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY
);

DROP TABLE IF EXISTS logging_event_property;
CREATE TABLE logging_event_property
(
    event_id BIGINT NOT NULL,
    mapped_key VARCHAR(254) NOT NULL,
    mapped_value TEXT,
    PRIMARY KEY(event_id, mapped_key)
);

DROP TABLE IF EXISTS logging_event_exception;
CREATE TABLE logging_event_exception
(
    event_id BIGINT NOT NULL,
    i SMALLINT NOT NULL,
    trace_line VARCHAR(255) NOT NULL,
    PRIMARY KEY(event_id, i)
);