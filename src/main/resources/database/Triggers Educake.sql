CREATE OR REPLACE TRIGGER personBirthDate
  BEFORE INSERT OR UPDATE ON Person
  FOR EACH ROW
BEGIN
  IF(:new.birthDate < date '1900-01-01' or 
     :new.birthDate > TO_CHAR(SYSDATE) )
  THEN
    RAISE_APPLICATION_ERROR( 
      -20001, 
      'The range is not allowed!' );
  END IF;
END;


CREATE OR REPLACE TRIGGER personCPF
  BEFORE INSERT OR UPDATE ON Person
  FOR EACH ROW
BEGIN
  IF(:new.CPF != 11)
  THEN
    RAISE_APPLICATION_ERROR( 
      -20001, 
      'The range is not allowed!' );
  END IF;
END;


CREATE OR REPLACE TRIGGER PaymentDate
  BEFORE INSERT OR UPDATE ON Payment
  FOR EACH ROW
BEGIN
  IF(:new.PAYMENTDATE != TO_CHAR(SYSDATE) )
  THEN
    RAISE_APPLICATION_ERROR( 
      -20001, 
      'The range is not allowed!' );
  END IF;
END;


CREATE OR REPLACE TRIGGER PaymentDate
  BEFORE INSERT OR UPDATE ON Payment
  FOR EACH ROW
BEGIN
  IF(:new.VALUE < 0 )
  THEN
    RAISE_APPLICATION_ERROR( 
      -20001, 
      'Negative value not allowed!' );
  END IF;
END;

CREATE OR REPLACE TRIGGER AddressCep  
BEFORE INSERT OR UPDATE ON Address 
FOR EACH ROW 
BEGIN  
    IF (:new.cep != 8)  
    THEN  
       RAISE_APPLICATION_ERROR( 
      -20001, 
      'Address Cep range not allowed!' );
  END IF;
END;  


CREATE OR REPLACE TRIGGER AddressHouseNumber
  BEFORE INSERT OR UPDATE ON Address
  FOR EACH ROW
BEGIN
  IF(:new.houseNumber < 0)
  THEN
    RAISE_APPLICATION_ERROR( 
      -20001, 
      'HouseNumber range not allowed!' );
  END IF;
END;

