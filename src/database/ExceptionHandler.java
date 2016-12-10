

package Database;

import SQLExceptions.INSERTException;
import SQLExceptions.SELECTException;
import SQLExceptions.UPDATEException;
import java.sql.SQLException;


public class ExceptionHandler {
    
    private static final ExceptionHandler handler = new ExceptionHandler();
    
    public void ExceptionHandling(SQLException ex) throws SELECTException, UPDATEException, INSERTException{
        SELECTExceptionHandling(ex);
    }
    
    private void SELECTExceptionHandling(SQLException ex) throws SELECTException, UPDATEException, INSERTException{
        
        switch(ex.getErrorCode()){
            case 104:
                
            case 108:
                
            case 116:
                
            case 120:
                
            case 121:
                
            case 141:
                
            case 145:
                
            case 147:
                
            case 177:
                
            case 194:
                
            case 196:
                
            case 199:
                
            case 263:
                
            case 268:
                
            case 411:
                
            case 444:
                
            case 458:
                
            case 539:
            
            case 584:
                throw new SELECTException();
            default:
                UPDATEExceptionHandling(ex);
        }
    }
    
    private void UPDATEExceptionHandling(SQLException ex) throws UPDATEException, INSERTException{
        
        switch(ex.getErrorCode()){
            case 115:
             
            case 140:
                
            case 157:
              
            case 272:
                
            case 286: 
                
            case 338:
                
            case 414:
                
            case 417:
                
            case 513:
                
            case 532:
                
            case 548:
                
            case 550:
                
            case 582:
                
            case 611:
                
            case 968:
                
            case 969:
                throw new UPDATEException();
                
            default:
                INSERTExceptionHandling(ex);                        
        }
    }
    
    private void INSERTExceptionHandling(SQLException ex) throws INSERTException, UPDATEException{
        
        switch(ex.getErrorCode()){
            case 109:
            
            case 110:
                
            case 120:
                
            case 121:
                
            case 171:
                
            case 197:
                
            case 199:
                
            case 223:
                
            case 311:
                
            case 314:
                
            case 338:
                
            case 404:
                
            case 428:
                
            case 483:
                
            case 513:
                
            case 515:
                
            case 544:
                
            case 545:
                
            case 548:
                
            case 550:
                
            case 556:
                
            case 563:
                
            case 578:
                
            case 595:
                
            case 611:
                
            case 674:
                throw new INSERTException();
                
            default:
                DELETEExceptionHandling(ex);
        }
    }
    
    private void DELETEExceptionHandling(SQLException ex) throws UPDATEException{
        
        switch(ex.getErrorCode()){
            case 415:
                throw new UPDATEException();
        }
    }

}
