public class Polynomial {
	
	double[] coef;

	public Polynomial() {
		coef = new double[1];
		coef[0] = 0;
	}

	Polynomial( double [] arg) {
		coef = new double[arg.length];
		for(int i = 0; i < coef.length; i++) {
			coef[i] = arg[i];
		}
	}
	

	public Polynomial add(Polynomial obj){
		
	   plen = Math.max(coef.length, obj.lenth);
	   
	   double sum[] = new double[];

        for(int i=0;i<plen;i++)
        {
            sum[i] = coef[i]+other.coef[i];
        }
        Polynomial newpoly = new Polynomial(sum);
        
	   return newpoly;


	}

    public double evaluate(double x)
    {
        double sum = 0;
        for(int i = 0; i<coef.length; i++)
        {
            sum+=(coef[i]*Math.pow(x,i));
        }
        return sum;
    }

	public boolean hasRoot( double number) {
		if (evaluate(number) == 0) return true;
		return false;
	}
}