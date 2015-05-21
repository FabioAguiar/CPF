package pack;

import java.util.Random;

public class GeradorCPF {
	
	
	public String gerarCPF(){
		
//	    log("Generating random integers in the range 1..10.");
	    
	    int START = 100000000;
	    int END = 999999999;
	    String primeiroDigito, segundoDigito;
	    Random random = new Random();
	    StringBuffer novePrimeirosNumeros = gerarNumeroRandomicoCPF(START, END, random);
	    primeiroDigito = gerarPrimeiroDigitoCPF(novePrimeirosNumeros);
	    StringBuffer dezPrimeirosNumeros = novePrimeirosNumeros;
	    dezPrimeirosNumeros.append(primeiroDigito);
	    segundoDigito = gerarSegundoDigitoCPF(dezPrimeirosNumeros);
	    
	    StringBuffer cpf = dezPrimeirosNumeros;
	    cpf.append(segundoDigito);
	    
	    System.out.println("cpf: " + cpf.toString());
	    
	    
		return null;
	}
	
	  private StringBuffer gerarNumeroRandomicoCPF(int startRange, int endRange, Random aRandom){
		    if (startRange > endRange) {
		      throw new IllegalArgumentException("Start cannot exceed End.");
		    }
		    long range = (long)endRange - (long)startRange + 1;
		    long fraction = (long)(range * aRandom.nextDouble());
		    Integer numeroRandomico =  Integer.valueOf((int) fraction + startRange); 
		    //Caso o número gerado randomicamente seja repetitivo o método é novamente chamado para gerar outro número
		    if (numeroRandomico.equals(000000000) || numeroRandomico.equals(111111111) ||
		        numeroRandomico.equals(222222222) || numeroRandomico.equals(333333333) ||
		        numeroRandomico.equals(444444444) || numeroRandomico.equals(555555555) ||		    		
		        numeroRandomico.equals(666666666) || numeroRandomico.equals(777777777) ||			    		
		        numeroRandomico.equals(888888888) || numeroRandomico.equals(999999999)){ 
		    
		    		gerarNumeroRandomicoCPF(startRange, endRange, aRandom);
		    	
		    }
		    log("Generated : " + numeroRandomico);
		    
		    return new StringBuffer().append(numeroRandomico);
		  }
		 
	  private String gerarPrimeiroDigitoCPF(StringBuffer numero){
		  Long somatorio = (long) 0;
		  Long n1 = Long.valueOf(numero.substring(0, 1));
		  Long n2 = Long.valueOf(numero.substring(1, 2));
		  Long n3 = Long.valueOf(numero.substring(2, 3));		  
		  Long n4 = Long.valueOf(numero.substring(3, 4));		  
		  Long n5 = Long.valueOf(numero.substring(4, 5));		  
		  Long n6 = Long.valueOf(numero.substring(5, 6));		  
		  Long n7 = Long.valueOf(numero.substring(6, 7));		  
		  Long n8 = Long.valueOf(numero.substring(7, 8));		  
		  Long n9 = Long.valueOf(numero.substring(8, 9));
		  
		  //Cada número gerado deverá ser multiplicado separadamente na ordem da esquerda para direita pelos
		  // seguintes números: 10, 9, 8, 7, 6, 5, 4, 3, 2
		  n1 *= 10;
		  n2 *= 9;
		  n3 *= 8;
		  n4 *= 7;
		  n5 *= 6;		  
		  n6 *= 5;
		  n7 *= 4;		  
		  n8 *= 3;
		  n9 *= 2;
		  //Após a multiplicação, somam-se todos os números
		  somatorio = n1+n2+n3+n4+n5+n6+n7+n8+n9;
		  
		  //Caso o resto da divisão for menor que 2, o primeiro dígito verificador será 0, caso contrário subtrai-se o resto de 11.
		  if(somatorio%11<2){
			  return "0";
		  }else{
			  return String.valueOf(Integer.valueOf(String.valueOf(11-somatorio%11)));
		  }
	  }
	  
	  private String gerarSegundoDigitoCPF(StringBuffer numero){
		  Long somatorio = (long) 0;
		  Long n1 = Long.valueOf(numero.substring(0, 1));
		  Long n2 = Long.valueOf(numero.substring(1, 2));
		  Long n3 = Long.valueOf(numero.substring(2, 3));		  
		  Long n4 = Long.valueOf(numero.substring(3, 4));		  
		  Long n5 = Long.valueOf(numero.substring(4, 5));		  
		  Long n6 = Long.valueOf(numero.substring(5, 6));		  
		  Long n7 = Long.valueOf(numero.substring(6, 7));		  
		  Long n8 = Long.valueOf(numero.substring(7, 8));		  
		  Long n9 = Long.valueOf(numero.substring(8, 9));
		  Long n10 = Long.valueOf(numero.substring(9, 10));
		  
		  //Cada número gerado deverá ser multiplicado separadamente na ordem da esquerda para direita pelos
		  // seguintes números: 11, 10, 9, 8, 7, 6, 5, 4, 3, 2
		  n1 *= 11;		  
		  n2 *= 10;
		  n3 *= 9;
		  n4 *= 8;
		  n5 *= 7;
		  n6 *= 6;		  
		  n7 *= 5;
		  n8 *= 4;
		  n9 *= 3;
		  n10 *= 2;
		  //Após a multiplicação, somam-se todos os números
		  somatorio = n1+n2+n3+n4+n5+n6+n7+n8+n9+n10;
		  
		  //Caso o resto da divisão for menor que 2, o primeiro dígito verificador será 0, caso contrário subtrai-se o resto de 11.
		  if(somatorio%11<2){
			  return "0";
		  }else{
			  return String.valueOf(Integer.valueOf(String.valueOf(11-somatorio%11)));
		  }
	  }
	  
	  private void log(String aMessage){
		    System.out.println(aMessage);
		 }
}
