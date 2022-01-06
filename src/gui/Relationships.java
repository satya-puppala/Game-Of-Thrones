package gui;
import java.util.HashMap;

/**
 *
 * @author Scott
 */
public class Relationships {
	
//HashMap to store all the different relationships from traversing the graph
	 HashMap<String,String> relationship = new HashMap<>();
	
	 // adding the relationships to the HashMap
	public Relationships(){
            
         //Coursework required Relationships   
	 // 1 steps required
	 relationship.put("Mother","Mother");
	 relationship.put("Father","Father");
	 relationship.put("Daughter","Daughter");
	 relationship.put("Son","Son");
         relationship.put("Parent","Parent");
         relationship.put("Descendant","Descendant");
	 //2 steps required
	 relationship.put("SonMother","Brother");
	 relationship.put("SonFather","Brother");
	 relationship.put("DaughterMother","Sister");
	 relationship.put("DaughterFather","Sister");
         relationship.put("DescendantParent","Sibling");
	 relationship.put("MotherFather","Grandmother");
	 relationship.put("MotherMother","Grandmother");
	 relationship.put("FatherMother","Grandfather");
	 relationship.put("FatherFather","Grandfather");
         relationship.put("ParentFather","Grandparent");
         relationship.put("ParentMother","Grandparent");
	 relationship.put("DaughterDaughter","Grand-daughter");
         relationship.put("DaughterDescendant","Grand-daughter");
	 relationship.put("DaughterSon","Grand-daughter");
	 relationship.put("SonDaughter","Grandson");
         relationship.put("SonDescendant","Grandson");
	 relationship.put("SonSon","Grandson");
	 // 3 steps required
	 relationship.put("SonSonFather","Nephew");
	 relationship.put("SonSonMother","Nephew");
	 relationship.put("SonDaughterFather","Nephew");
	 relationship.put("SonDaughterMother","Nephew");
         relationship.put("SonDescendantParent","Nephew");
	 relationship.put("DaughterSonFather","Niece");
	 relationship.put("DaughterSonMother","Niece");
	 relationship.put("DaughterDaughterFather","Niece");
	 relationship.put("DaughterDaughterMother","Niece");
	 relationship.put("SonFatherMother","Uncle");
	 relationship.put("SonMotherFather","Uncle");
         relationship.put("SonMotherMother","Uncle");
         relationship.put("SonFatherFather","Uncle");
         relationship.put("DescendantParentFather","Uncle");
	 relationship.put("DaughterFatherFather","Aunt");
	 relationship.put("DaughterMotherFather","Aunt");
         relationship.put("DaughterFatherMother","Aunt");
         relationship.put("DaughterMotherMother","Aunt");
         //4 step required
          relationship.put("SonSonFatherMother","Cousin");
	 relationship.put("SonSonFatherFather","Cousin");
	 relationship.put("SonSonMotherFather","Cousin");
	 relationship.put("SonSonMotherMother","Cousin");
	 relationship.put("DaughterDaughterFatherMother","Cousin");
	 relationship.put("DaughterDaughterFatherFather","Cousin");
	 relationship.put("DaughterDaughterMotherFather","Cousin");
	 relationship.put("DaughterDaughterMotherMother","Cousin");
	 relationship.put("SonDaughterMotherFather","Cousin");
	 relationship.put("SonDaughterFatherMother","Cousin");
	 relationship.put("SonDaughterFatherFather","Cousin");
	 relationship.put("SonDaughterMotherMother","Cousin");
	 relationship.put("DaughterSonMotherMother","Cousin");
	 relationship.put("DaughterSonFatherFather","Cousin");
	 relationship.put("DaughterSonMotherFather","Cousin");
	 relationship.put("DaughterSonFatherMother","Cousin");
         
         
         /*Extra Relationships to show how this can be expanded  
         for any and all relationships as required.
         */
         //1 Step Extra 
         relationship.put("Husband","Husband");
	 relationship.put("Wife","Wife");
         //3 Step Extra
         relationship.put("SonDaughterSon","Great-Grandson");
         relationship.put("SonDaughterDaughter","Great-Grandson");
         relationship.put("SonSonSon","Great-Grandson");
         relationship.put("SonSonDaughter","Great-Grandson");
         relationship.put("DaughterDaughterSon","Great-Grand-daughter");
         relationship.put("DaughterDaughterDaughter","Great-Grand-daughter");
         relationship.put("DaughterSonSon","Great-Grand-daughter");
         relationship.put("DaughterSonDaughter","Great-Grand-daughter");
         relationship.put("DaughterDaughterDescendant","Great-Grand-daughter");
         relationship.put("DaughterSonDescendant","Great-Grand-daughter");
         relationship.put("SonSonDescendant","Great-Grandson");
         relationship.put("SonDaughterDescendant","Great-Grandson");
         relationship.put("FatherFatherMother","Great-Grandfather");
         relationship.put("FatherFatherFather","Great-Grandfather");
         relationship.put("FatherMotherFather","Great-Grandfather");
         relationship.put("FatherMotherMother","Great-Grandfather");
         relationship.put("MotherFatherMother","Great-Grandmother");
         relationship.put("MotherMotherMother","Great-Grandmother");
         relationship.put("MotherMotherFather","Great-Grandmother");
         relationship.put("MotherMotherMother","Great-Grandmother");
         relationship.put("ParentFatherFather","Great-Grandparent");
         relationship.put("ParentMotherMother","Great-Grandparent");
         relationship.put("ParentFatherMother","Great-Grandparent");
         relationship.put("ParentMotherFather","Great-Grandparent");
	 // 3 steps no blood relation Extra
	 relationship.put("WifeSonFather","Sister-in-law");
         relationship.put("WifeSonMother","Sister-in-law");
	 relationship.put("SonFatherHusband","Brother-in-law");
	 relationship.put("HusbandDaughterFather","Brother-in-law");
	 relationship.put("SonFatherWife","Brother-in-law");
	 // 4 steps  Extra
         relationship.put("DaughterSonMotherHusband","Niece through Marriage");
         relationship.put("WifeSonMotherFather","Aunt through Marriage");
         
         relationship.put("SonFatherFatherMother","Great-Uncle");
         relationship.put("SonDaughterSonFather","Great-Nephew");
         
         relationship.put("SonDaughterSonDescendant","Great Great-Grandson");
         relationship.put("ParentFatherFatherMother","Great Great-Grandparent");
	 // 4 steps no blood relation Extra
	 relationship.put("HusbandDaughterFatherFather","Uncle-in-law");
	 
	 relationship.put("WifeSonFatherMother","Aunt through marriage");
	 
	 relationship.put("SonSonFatherWife","Nephew through marriage");
	 
	 relationship.put("DaughterSonFatherWife","Niece through marriage");
         
         //5 steps Extra
         relationship.put("SonDaughterSonDescendantParent","Great Great-Nephew");
         relationship.put("DescendantParentFatherFatherMother","Great Great-Uncle");
	 
	 
	 
	 
	 
	 
	 
	 
	}

	 
	 
	 
	 
	 
	 
	 
	
}
