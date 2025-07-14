CREATE TABLE books (
    book_id BIGSERIAL PRIMARY KEY,
    title TEXT NOT NULL,
    author TEXT,
    publication_year VARCHAR(10),
    category TEXT,
    language TEXT,
    pages_number INTEGER,
    total_copies_number INTEGER,
    available_copies_number INTEGER
);

CREATE TABLE members (
    member_id BIGSERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL,
    phone_number TEXT,
    registration_date DATE NOT NULL,
    subscription_type TEXT
);

CREATE TABLE loans (
    loan_id BIGSERIAL PRIMARY KEY,
    book_id BIGINT NOT NULL,
    member_id BIGINT NOT NULL,
    loan_date DATE NOT NULL,
    due_date DATE NOT NULL,
    return_date DATE,
    status TEXT CHECK (status IN ('ACTIVE', 'RETURNED', 'LATE')),

    CONSTRAINT fk_book
        FOREIGN KEY (book_id)
        REFERENCES books(book_id)
        ON DELETE CASCADE,

    CONSTRAINT fk_member
        FOREIGN KEY (member_id)
        REFERENCES members(member_id)
        ON DELETE CASCADE
);
