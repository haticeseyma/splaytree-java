public class splayNODE {
    splayNODE sol, sag, parent;
    int data;
    

    /** Constructor **/
    public splayNODE()
    {
        this(0, null, null, null);
    }          
    /** Constructor **/
    public splayNODE(int data)
    {
        this(data, null, null, null);
    } 
    /** Constructor **/
    public splayNODE(int data, splayNODE sol, splayNODE sag, splayNODE parent)
    {
        this.sol = sol;
        this.sag = sag;
        this.parent = parent;
        this.data = data;         
    }    
}

    
 
    
