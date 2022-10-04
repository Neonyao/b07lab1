import java.io.File;
import java.util.Arrays;
import java.lang.Math;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;


public class Polynomial {
	
	double[] coef;
	int[] exp;

	public Polynomial() {
		this.coef = new double[1];
		this.coef[0] = 0;
		this.exp = new int[1];
		this.exp[0] = 0;
	}
    

    	public Polynomial(double[] coef, int[] exp) {
		this.coef = coef;
		this.exp = exp;
   	}
	
	
    	public Polynomial(File file) throws IOException {
		
		FileReader readed = new FileReader(file);
		BufferedReader textReader = new BufferedReader(readed);
		
		String text = textReader.readLine();
		String[] strs = text.split("\\+|-");

		double returnCoef[] = new double[strs.length];
		int returnExp[] = new int[strs.length];
		int i = 0;
		
		for (String str: strs) {
		    if (str.contains("x")) {
			String[] tempSplit = str.split("x");
			returnCoef[i] = Double.parseDouble(tempSplit[0]);
			returnExp[i] = Integer.parseInt(tempSplit[1]);
		    }
		    else {
			returnCoef[i] = Double.parseDouble(str);
			returnExp[i] = 0;
		    }
		    i++;
		}
		this.coef = returnCoef;
		this.exp = returnExp;
    }		
	
	
	

    public Polynomial add(Polynomial p2) {
        
	int len1 = this.coef.length;

        int len2 = p2.coef.length;

        double[] sum = new double[Math.max(len1, len2)];
	int[] sexp = new int[Math.max(len1, len2)];

        for (int i = 0; i < len1; i++)
        {
            sum[i] += this.coef[i];
	    sexp[i] += this.exp[i];
        }
	
	
        for (int i = 0; i < len2; i++)
        {
            sum[i] += p2.coef[i];
	    sexp[i] += p2.exp[i];
        }
	

        return new Polynomial(sum,sexp);
    }
	
	


    public double evaluate(double x)
    {
        double sum = 0;
        for(int i = 0; i<this.coef.length; i++)
        {
            sum+=(this.coef[i]*Math.pow(x, this.exp[i]));
        }
        return sum;
    }

	public boolean hasRoot( double n) {
		if (evaluate(n) == 0) return true;
		return false;
	}
	
	
       public Polynomial multiply(Polynomial p) {
	       
	       
	       
	       
	       
	       
       }
	
	
	

	public void saveToFile(File f) throws Exception{
		String out = "";
		for (int i = 0; i < coef.length; i++) {
		   if (this.exp[i] == 0) {
			if (this.coef[i] >= 0) {
			    out += "+" + Double.toString(this.coef[i]);
			}
			else {
			    out += Double.toString(this.coef[i]);
			}
		    }
		    else {
			if (this.coef[i] >= 0) {
			    out += "+" + Double.toString(this.coef[i]) + "x" + Integer.toString(this.exp[i]);
			}
			else {
			    out += Double.toString(this.coef[i]) + "x" + Integer.toString(this.exp[i]);
			}
            }
		}
	    FileWriter newfile; 
	    newfile = new FileWriter(f);
	    newfile.write(out);
	    newfile.close();
	}
	
    
}
