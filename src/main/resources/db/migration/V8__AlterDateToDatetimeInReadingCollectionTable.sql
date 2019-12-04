ALTER TABLE healthserver.reading_collection drop column date;
ALTER TABLE healthserver.reading_collection ADD COLUMN date timestamp;