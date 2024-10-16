--テーブルが存在したら削除する
DROP TABLE IF EXISTS todos;

--テーブルを作成する
CREATE TABLE todos (
  id serial PRIMARY KEY,
  todo VARCHAR(255) NOT NULL,
  detail text,
  created_at timestamp without time zone,
  updated_at timestamp without time zone
);