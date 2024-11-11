package Assignment2; //1

public class cls_Class2 
{
	cls_Subjects subjects = new cls_Subjects();
	
	public void call_clsSubjects(int unit, float mid, float fin)
	{
		subjects.subj_units(unit);
		subjects.midGrades(mid);
		subjects.finGrades(fin);
	}
	
	public void call_clsSubjects(float mid, float fin)
	{
		subjects.method_call_clsComputeAveGrade(mid, fin);
	}
}
