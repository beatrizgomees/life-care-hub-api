ALTER TABLE tb_user DROP COLUMN id;
-- Switch to using Supplier.uuid as the primary key.
ALTER TABLE tb_user ADD COLUMN id UUID PRIMARY KEY NOT NULL;