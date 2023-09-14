package MainPackage;

import java.util.Objects;

public class Mark {
	private double firstAttestation;
	private double secondAttestation;
	private double finalExam;
	
	public Mark() {
		
	}
	public Mark(double firstAtt, double secondAtt, double finalEx) {
		this.firstAttestation = firstAtt;
		this.secondAttestation = secondAtt;
		this.finalExam = finalEx;
	}
	
	private final String[] gpaGrades = {"A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "F"};
	
	private final double [] numberGrades = {4.00, 3.67, 3.33, 3.00, 2.67, 2.33, 2, 1.67, 1.33, 1.00, 0};
	
	public double getMarksFirstAtt() {
		return this.firstAttestation;
	}
	public double getMarksSecondAtt() {
		return this.secondAttestation;
	}
	
	public double getMarkFinalExam() {
		return this.finalExam;
	}
	
	 private boolean checkAttMark(double firstAttestation, double secondAttestation){
	        return firstAttestation >= 0 && secondAttestation >= 0 && firstAttestation + secondAttestation <= 60;
	    }
	
	  public boolean setFirstAttestation(double firstAttestation){
	        if (checkAttMark(firstAttestation, secondAttestation)) {
	            this.firstAttestation = firstAttestation;
	            return true;
	        }
	        return false;
	    }
	  
	  
	  public boolean setSecondAttestation(double secondAttestation){
	        if (checkAttMark(firstAttestation, secondAttestation)) {
	            this.secondAttestation = secondAttestation;
	            return true;
	        }
	        return false;
	    }
	  
	  
	  public boolean setFinalExam(double finalExam) {
	        if (finalExam < 0 && finalExam > 40  && (firstAttestation + secondAttestation)< 30){
	            return false;
	        }
	        this.finalExam = finalExam;
	        return true;
	    }
	

	public 	double getTotalMark() {
		 return firstAttestation + secondAttestation + finalExam;
	}
	
	
	public String getMarkLetter(){
        if(finalExam < 20 || firstAttestation + secondAttestation < 30) return gpaGrades[10];
        return gpaGrades[Math.min(Math.max(0, 19 - (int)(getTotalMark()/5)), 10)];
    }
	
	
	public double getNumberMark() {
		return numberGrades[Math.min(Math.max(0, 19 - (int)(getTotalMark()/5)), 10)];
	}
	
	public String toString(){
        return "First attestation: " + firstAttestation + ", Second attestation: " + secondAttestation +
                ", Final: " + finalExam + ". Total: " + getTotalMark() + " ( Mark: " + getMarkLetter() + " " + getNumberMark() + " )";
    }
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Objects.hash(finalExam, firstAttestation, secondAttestation);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mark other = (Mark) obj;
		return Double.doubleToLongBits(finalExam) == Double.doubleToLongBits(other.finalExam)
				&& Double.doubleToLongBits(firstAttestation) == Double.doubleToLongBits(other.firstAttestation)
				&& Double.doubleToLongBits(secondAttestation) == Double.doubleToLongBits(other.secondAttestation);
	}
	
	
}
