public class Polynomial {
	
	double[] coef;

	public Polynomial() {
        coef = new double[] {0};
    }
    

	public Polynomial(double arg[]) {
		coef = new double[arg.length];
		for(int i = 0; i < arg.length; i++) {
			coef[i] = arg[i];
		}
	}
	

    public Polynomial add(Polynomial p2) {
        
	  int len1 = this.coef.length;

        int len2 = p2.coef.length;

        double[] sum = new double[Math.max(len1, len2)];

        for (int i = 0; i < len1; i++)
        {
            sum[i] += this.coef[i];
        }
	
	if (len1 < len2){
        for (int i = 0; i < len2; i++)
        {
            sum[i] += p2.coef[i];
        }
	}

        return new Polynomial(sum);
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

	public boolean hasRoot( double n) {
		if (evaluate(n) == 0) return true;
		return false;
	}
}