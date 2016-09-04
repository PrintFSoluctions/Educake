----- NÃO USE EM PRODUÇÃO!! -----
DROP TABLE IF EXISTS Payment;
DROP TABLE IF EXISTS Bill;
DROP TABLE IF EXISTS BillType;
DROP TABLE IF EXISTS Person;
---------------------------------

CREATE TABLE Person (
  idPerson  INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name      VARCHAR(20) NOT NULL,
  surname   VARCHAR(60) NOT NULL,
  birthdate DATE        NOT NULL
);

CREATE TABLE BillType(
  idBillType  INT         NOT NULL PRIMARY KEY AUTO_INCREMENT,
  name        VARCHAR(30) NOT NULL
);

CREATE TABLE Bill (
  idBill            INT           NOT NULL PRIMARY KEY AUTO_INCREMENT,
  idPerson          INT           NOT NULL,
  idBillType        INT           NOT NULL,
  `value`           DECIMAL(7,2)  UNSIGNED NOT NULL,
  firstInstallment  DATE          NOT NULL, -- Data de início dos pagamentos: "primeiro vencimento"
  installments      INT           UNSIGNED NOT NULL DEFAULT 1, -- Parcelas
  due               DATE          NOT NULL, -- Vencimento

  CONSTRAINT `fk_bill_person`
    FOREIGN KEY (idPerson)
    REFERENCES Person(idPerson)
    ON UPDATE CASCADE
    ON DELETE NO ACTION,

  CONSTRAINT `fk_bill_billtype`
    FOREIGN KEY (idBillType)
    REFERENCES BillType(idBillType)
    ON UPDATE CASCADE
    ON DELETE NO ACTION
);

CREATE TABLE Payment (
  idPayment   INT           NOT NULL PRIMARY KEY AUTO_INCREMENT,
  idBill      INT           NOT NULL,
  `value`     DECIMAL(7,2)  UNSIGNED NOT NULL,
  paymentDate DATE          NOT NULL, -- Pra conferir se houve pagamento em atraso

  CONSTRAINT `fk_payment_bill`
    FOREIGN KEY (idBill)
    REFERENCES Bill(idBill)
    ON UPDATE CASCADE
    ON DELETE CASCADE
);
