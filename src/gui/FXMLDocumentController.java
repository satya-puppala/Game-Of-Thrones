package gui;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 *
 * @author Scott
 */
public class FXMLDocumentController implements Initializable {
    
    //Map to store Person objects, used for quick reference and to access relationship between nodes. 
    HashMap<String,Person> tree = new HashMap<>();
    //LinkedList to keep node
    ArrayList<Person> treeNav = new ArrayList<>();
    //scanner will be used to read the family files
    Scanner sc;
    //ObservableList to be used in load2 method
    ObservableList <String> myList;
    
    //variables 
    String load = "Empty";
    String compare1, compare2; 
    @FXML private ListView listView;
    @FXML private Button edit;
    @FXML private Button update;
    @FXML private Button compare;
    @FXML private Button txtFile;
    @FXML private Button dotFile;
    @FXML private TextField name;   
    @FXML private TextField gender;
    @FXML private TextField alive;
    @FXML private TextField trait;
    @FXML private  ComboBox<String> name1;
    @FXML private  ComboBox<String> name2;
    @FXML private TextArea relationship;
    @FXML private TextArea relationshipAnswer;
    
    //Method to be used to load selected family into the ListView and combo boxes
    public void load2()
    {
       //clearing the selection from the combobox 
       name1.getSelectionModel().clearSelection();
       name2.getSelectionModel().clearSelection();
       // initializing the array
       myList = FXCollections.observableArrayList();
       //adding all objects from main array to observable array.
       for (int i =0; i<treeNav.size(); i++)
       myList.add(treeNav.get(i).getName());
       //sorting  observable array
       Collections.sort(myList);
       //adding observable array to the listview 
       listView.getItems().setAll(myList);
       //adding observable array to combo boxes
       name1.getItems().setAll(myList);
       name2.getItems().setAll(myList);
       //clearing the observable array so it does not create duplicates if selected again. 
       myList.clear();
       //disabling text fields so they are not edited accidentally. 
       name.setDisable(true);
       gender.setDisable(true);
       alive.setDisable(true);
       trait.setDisable(true); 
    }
    //method to fill textfields with the selected persons information. 
    @FXML
    private void listViewAction(MouseEvent event) {
       /*disabling the textfield everytime a new person is selected from the
        listView.*/
       name.setDisable(true);
       gender.setDisable(true);
       alive.setDisable(true);
       trait.setDisable(true);
       update.setDisable(false);
        try{    
       // getting selected Object from the list in the table
       String selected = listView.getSelectionModel().getSelectedItem().toString();
       
       //setting Textfield with the selected Objects corrospoding values
       name.setText(tree.get(selected).getName());
       gender.setText(tree.get(selected).getGender());
       alive.setText(tree.get(selected).getAlive());
       trait.setText(tree.get(selected).getrait());
     }
       catch(Exception e){
       //Alert to the user
       Alert alert = new Alert(Alert.AlertType.WARNING);
       alert.setTitle("Selected Person");
       alert.setHeaderText(null);
       alert.setContentText("List is empty! Select a house to fill the list");
       alert.showAndWait();  
    }
     }
    //method to fill the list view when the Stark House is clicked. 
    @FXML
    private void starkButtonAction(MouseEvent event) {
       treeNav.clear();
       load = "Starks";
       loadData(load+".txt");
       load2();
    }
    //method to fill the list view when the Bartheon House is clicked. 
    @FXML
    private void bartheonButtonAction(MouseEvent event) {
       treeNav.clear();
       load= "Baratheon";
       loadData(load+".txt");
       load2();
    }
    //method to fill the list view when the Arryn House is clicked. 
    @FXML
    private void arrynButtonAction(MouseEvent event) {
       treeNav.clear();
       load= "Arryn";
       loadData(load+".txt");
       load2();
    }
    //method to fill the list view when the Greyjoy House is clicked. 
     @FXML
    private void greyjoyButtonAction(MouseEvent event) {
       treeNav.clear();
       load= "Greyjoy";
       loadData(load+".txt");
       load2();
    }
     //method to fill the list view when the Martell House is clicked. 
     @FXML
    private void martellButtonAction(MouseEvent event) {
       treeNav.clear();
       load= "Martell";
       loadData(load+".txt");
       load2();
    }
    //method to fill the list view when the Martell House is clicked. 
     @FXML
    private void tyrellButtonAction(MouseEvent event) {
       treeNav.clear();
       load= "Tyrell";
       loadData(load+".txt");
       load2();
    }
    //method to fill the list view when the Lannister House is clicked. 
      @FXML
    private void lannisterButtonAction(MouseEvent event) {
       treeNav.clear();
       load= "Lannister";
       loadData(load+".txt");
       load2();
    }
    //method to fill the list view when the Targaryen House is clicked. 
     @FXML
    private void targaryenButtonAction(MouseEvent event) {
       treeNav.clear();
       load = "Targaryen";
       loadData(load+".txt");
       load2();
    }
    //method to fill the list view when the Tully House is clicked. 
     @FXML
    private void tullyButtonAction(MouseEvent event) {
       treeNav.clear();
       load = "Tully";
       loadData(load+".txt");
       load2();
    }
    //method to fill the list view when the All-Houses is clicked. 
    @FXML
    private void allHousesButtonAction(MouseEvent event) {
       treeNav.clear();
       load = "All Houses";
       loadData(load+".txt");
       load2();
    }
    //method to make the text fields editable 
    @FXML
    private void editButtonAction(ActionEvent event) {
    
       name.setDisable(false);
       gender.setDisable(false);
       alive.setDisable(false);
       trait.setDisable(false);
    }
    //method to run the update method when button is clicked
    @FXML
    private void updateButtonAction(ActionEvent event) {
      update();
    }
    //closes the program
     @FXML
    private void closeButtonAction(ActionEvent event) {
     Platform.exit();
     
    }
    //runs the saveDot method and show alert to the user
    @FXML
    private void dotFileAction(ActionEvent event) {
       saveDot(treeNav);
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Produce File");
       alert.setHeaderText(null);
       alert.setContentText(load+".dot file to use in gvedit.exe has been "
               + "produced. ");
       alert.showAndWait();  
    }
    //runs the writetoFile method and show alert to the user
    @FXML
    private void txtFileAction(ActionEvent event) {
       writeToFile(treeNav);
       Alert alert = new Alert(Alert.AlertType.INFORMATION);
       alert.setTitle("Produce File");
       alert.setHeaderText(null);
       alert.setContentText(load+" OrderedNames.txt file with all people sorted into"
               + " alphabetical order has been produced");
       alert.showAndWait();  
    }
    
    /*Method comparing to selected people, first checking they are not the same 
    person and then running the pathfinder method to show the user the shortest
    path in the graph between them and display there relationship. If there is 
    no path between the two people(nodes) then an alert will show to the user.
    */
    @FXML
    private void compareButtonAction(ActionEvent event) {
        
      try{   
        //clearing any previous displayed path and relationships
        relationship.clear();
        relationshipAnswer.clear();
        //setting 2 string with the selected person from each comboBox
        compare1 = tree.get(name1.getSelectionModel().getSelectedItem()).getName();  
        compare2 = tree.get(name2.getSelectionModel().getSelectedItem()).getName();
        //checking if its the same person and sending alert to user if it is. 
         if(compare1.equals(compare2)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Relationship Finder");
            alert.setHeaderText(null);
            alert.setContentText("PEOPLE SELECTED ARE THE SAME!");
            alert.showAndWait(); 
         }
         else{
            //calling the pathFinder method with the 2 selected names
            pathFinder(compare1,compare2);
        }
      }
      /* if no connection between the selected people an alert will show to the
      user
      */
      catch (Exception e)
      {
         Alert alert = new Alert(Alert.AlertType.WARNING);
         alert.setTitle("Relationship Finder");
         alert.setHeaderText(null);
         alert.setContentText("NO CONNECTION BETWEEN THESE TWO PEOPLE!");
         alert.showAndWait(); 
      }
    }
    //initialize method, runs when the application starts.
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       //Disabling textfields and update  button
       name.setDisable(true);
       gender.setDisable(true);
       alive.setDisable(true);
       trait.setDisable(true);
       update.setDisable(true);
       //making textareas uneditable
       relationship.setEditable(false);
       relationshipAnswer.setEditable(false);
       
       // setting constraints on the textfields to only allow letters
         name.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            name.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });
         
         gender.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            gender.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });
         
        alive.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            alive.setText(newValue.replaceAll("[^\\sa-zA-Z]", ""));
        }
    });
 
        trait.textProperty().addListener((observable, oldValue, newValue) -> {
        if (!newValue.matches("\\sa-zA-Z*")) {
            trait.setText(newValue.replaceAll("[^\\sa-zA-Z]", "/"));
        }
    }); 
       
    }  
     
    // Load data from a file method
    public void loadData(String families) {
		 	
        try {
			
	sc = new Scanner(new File(families));
	//read the file line by line
	while (sc.hasNextLine()) {			
            //defining the split between tokens
            String[] token =  sc.nextLine().split(",");				
            /*if statement to check there is 4 tokens on the current line being read,
            * if so a Person node will be made
            */
            if (token.length==4) {
					
		String name = token[0].trim(); 
		String gender = token[1].trim(); 
		String alive = token[2].trim();
		String trait = token[3].trim();
		//creating the person object and adding it to the array and hashmap				
		Person node = new Person(name,gender,alive,trait,null);
		tree.put(name,node);   
		treeNav.add(node);
		}
		/* adding Edge and weight between two nodes.
		*  In this case the relationship between parent and child is the weight
		*/
            else {
						
		String parent = token[0].trim(); 
		String relationship = token[1].trim(); 
		String child =  token[2].trim();
                //creating edge between 2 nodes with its weight(relationship)
		Edge personInfo = new Edge(tree.get(parent),relationship,tree.get(child));
		tree.get(parent).getConnection().add(personInfo);
				     
		/*This is for an undirected graph,if parent is connected to a child, the child
		// is connected to the parent. I then changed the relationship name to 
		to relivant*/
            switch(relationship){
                case "Husband":
                    relationship ="Wife";
                    Edge personInfo2 = new Edge(tree.get(child),relationship,tree.get(parent));
                    tree.get(child).getConnection().add(personInfo2);
                    break;
                case "Ex-Husband":
                    relationship ="Ex-Wife";
                    Edge personInfo3 = new Edge(tree.get(child),relationship,tree.get(parent));
                    tree.get(child).getConnection().add(personInfo3);
                    break;
                case "Parent":
                    relationship ="Descendant";
                    Edge personInfo4 = new Edge(tree.get(child),relationship,tree.get(parent));
                    tree.get(child).getConnection().add(personInfo4);
                    break;
                case "Lover":
                    Edge personInfo5 = new Edge(tree.get(child),relationship,tree.get(parent));
                    tree.get(child).getConnection().add(personInfo5);
                    break;
                case "Mother":
                    if(tree.get(child).getGender().equals("Male")){
                    relationship ="Son";
                    }
                    else if(tree.get(child).getGender().equals("Female")){
                    relationship ="Daughter";    
                    }
                    Edge personInfo6 = new Edge(tree.get(child),relationship,tree.get(parent));
                    tree.get(child).getConnection().add(personInfo6);
                    break;
                case "Father":
                    if(tree.get(child).getGender().equals("Male")){
                    relationship ="Son";
                    }
                    else if(tree.get(child).getGender().equals("Female")){
                    relationship ="Daughter";    
                    }
                    Edge personInfo7 = new Edge(tree.get(child),relationship,tree.get(parent));
                    tree.get(child).getConnection().add(personInfo7);
                    break;    
            }
		}
		}
		}
	//catching any errors
        catch (IOException e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Reading from file ");
                alert.setHeaderText(null);
                alert.setContentText("ERROR WHEN READING FILE!");
                alert.showAndWait();
		}
		}
    //Method to get the position in the List
    int indexForName(String name) {
        for (int i=0; i < treeNav.size(); i++) {
            if (treeNav.get(i).getName().equals(name)) {
	    return i;
	    }
	    }
	    return -1;
	    } 
    //Method to navigate the graph and display the shortest path between 2 given nodes (people)
    public void pathFinder (String name1, String name2)  
	    { 
	    	//boolean array to make a node as visited. 
	        boolean[] isVisited = new boolean[treeNav.size()]; 
	        //list to keep all the paths 
	        ArrayList<Person> pathList = new ArrayList<>(); 
	        //list to keep and return only the shortest path
	        List <Person> shortestPath = new ArrayList<>();
	        
	        //add source to pathList
	        pathList.add(tree.get(name1)); 
	          
	        //Call recursive utility 
	        pathFinderUtil(name1, name2, isVisited, pathList,shortestPath); 
	        
	        /*once the pathFinderUtil has finished, I can then extract the names
	         * and relationships along the path.  Telling the user not only what relation the 
	         * two people are but how (through which nodes) in this case people.
	         */
	        // Variables to be used when working out how the two people are related. 
	        String namer = null, namer2 = null, rel = null, relation ="";
	        /* here I am cycling through the array using i as the first step and j as the second
	         * moving them both through till the loop comes to an end and the array length -1
	         * As the loop cycles through it works out the relationship between the person and position 
	         * i and the person at position j until it comes to an end. 
	         * The relationship is worked out calling the relationship method I created. 
	         */
	        int j =1;
	        for (int i =0; i< shortestPath.size()-1; i++) {
        		
	             namer = shortestPath.get(i).getName();
	             namer2 = shortestPath.get(j).getName(); 
                     /*calling the relationship method nodes i and j
                     and storing the returned value in a string
                     */
	             rel = relation(namer, namer2);
                     relationship.appendText(namer +" is "+ rel+" to "+namer2 + "\n");
	             j++;
	             
	             //creating a string by joining all the relationships worked out. 
	 	     relation = relation + rel;
	        	}
	        /*storing the person at position 1, this is needed as the name sent into the method is
	         * changed when finding the shortest route
	         */
	        String nameP = shortestPath.get(0).getName();
	        //check to be marked true if a relation is found
	        boolean noRelation = true; 
	        //instance of the Relationship class 
	        Relationships relative = new Relationships();
	        
	        /*Checking if the relation string matches any of the keys in the HashMap in the 
	         * Relationship class. Will then return the relationship if matched and set the 
	         * noRelation boolean to false.  
	         */ 
	        for (String key : relative.relationship.keySet()){
                    if (key.equals(relation)) {
                        /*This check is make sure relationship is only sibling 
                        if the gender of the person is not given. And same for sibling.
                        All others Parent, Granparent etc are found in the relationship class. 
                        */
                            relationshipAnswer.setStyle
                            (" -fx-text-fill:green;");
                            noRelation=false;
         
                        switch(relative.relationship.get(key)){
                            case "Sibling":
         
                            switch (shortestPath.get(0).getGender()) {
                                case "Male":
                                    relationshipAnswer.appendText("Related"+"\n"+nameP +
                                    " is the Brother of " + namer2 );
                                break;
                                case "Female":
                                    relationshipAnswer.appendText("Related"+"\n"+nameP +
                                    " is the Sister of " + namer2 );
                                break;
                                default:
                                    relationshipAnswer.appendText("Related"+"\n"+nameP +
                                    " is the " +relative.relationship.get(key)+" of " + namer2 );
                                break;
                        }
                                break;
                            case "Descendant":
                                switch (shortestPath.get(0).getGender()) {
                                case "Male":
                                    relationshipAnswer.appendText("Related"+"\n"+nameP +
                                    " is the Son of " + namer2 );
                                break;
                                case "Female":
                                    relationshipAnswer.appendText("Related"+"\n"+nameP +
                                    " is the Daughter of " + namer2 );
                                break;
                                default:
                                    relationshipAnswer.appendText("Related"+"\n"+nameP +
                                    " is the " +relative.relationship.get(key)+" of " + namer2 );
                                break;
                        }
                                break;
                            default:
                                relationshipAnswer.appendText("Related"+"\n"+nameP +
                                " is the " +relative.relationship.get(key)+" of " + namer2 ); 
                                break;
                        }
                    }
	        }
	        //if noRelation is true print "No relation" to the user
	        if (noRelation)
	        {
                    relationshipAnswer.setStyle
                    (" -fx-text-fill:red;");
                    relationshipAnswer.appendText("\n"+"Not Related"); 
	        }
	    }
           
	    /* A recursive function to find the shortest path from name1 to name2, could also be adapted
	     * to print all paths with a simple loop or be greedy and grab the first completed.
	     * isVisited[] keeps track of visited vertices (people) in current path. 
	     * localPathList<> stores actual vertices in the current path.
	     * shortestPath will clear and store the localPathlist if it is smaller than what is currently
	     * stored in its list. 
	     */
    private void pathFinderUtil(String name1, String name2, 
	                            boolean[] isVisited, 
	                        List<Person> localPathList,
	                        List<Person> shortestPath) { 
	    	 
	    //getting the index for name1 using the indexForName method
	    int n1 = indexForName(name1);
	    // Mark the current node 
	    isVisited[n1] = true; 
	          
	    /*name1 will match name2 at the end of the current path and then check if localPath is
	    * shorter than shortest path, if so will overwrite it. 
	    */
	    if (name1.equals(name2))  
	    { 
	        if (localPathList.size() < shortestPath.size()||shortestPath.size()== 0)
	        {
                    shortestPath.clear();
                    shortestPath.addAll(localPathList);
	        	}
	        	
	            // if match found then no need to traverse more till depth 
	            isVisited[n1]= false; 
	            return ; 
	        } 
	          
	        // Recur for all the vertices adjacent to current vertex 
	        for (int i =0; i< treeNav.get(n1).getConnection().size(); i++)
	        {  
                    //getting the name of the current child node
                    String name = treeNav.get(n1).getConnection().get(i).getChild().getName();
                    //getting the index 
                    int n2 = indexForName(name);
	        
	            if (!isVisited[n2]) 
	            { 
	                // store current node in pathList 
	                localPathList.add(tree.get(name)); 
	                pathFinderUtil(name, name2, isVisited, localPathList,shortestPath); 
	                  
	                // remove current node in pathList
	                localPathList.remove(tree.get(name)); 
	            }   
	        }
	        
	        // Mark the current node 
	        isVisited[n1] = false; 
	    } 
	 //Method to get relationship 
    public String relation (String person1in, String person2in) {
		 
            String person1 = "";
            String person2 = "";
            String relationship = "";
		
            /*taking person1 and cycling though there relationships till a match is found and 
            * then returning the relationship. 
            */
            for (int i =0; i < tree.get(person1in).getConnection().size();i++) {
			 
                person1 = tree.get(person1in).getConnection().get(i).getParent().getName();
                person2 = tree.get(person1in).getConnection().get(i).getChild().getName();
                relationship = tree.get(person1in).getConnection().get(i).getRelationship();
			  
                if (person1.equals(person1in) && person2.equals(person2in))
			
                    return relationship;
		 }
			  
	  return "No relation"; 
	 }
	 
	 // Method to sort ArrayList into order and then print it line by line in to a .txt file
    public void writeToFile (ArrayList <Person> listIn) {
	
		 // new array just for sorting purposes 
		 ArrayList <String> myList = new ArrayList<>();
		 /*running through the array sent in and taking out all the name elements of the object,
		  *  then adding them to the temp array
		  */
		 for (int i =0; i< listIn.size();i++) {
	  	   
		  	String name = listIn.get(i).getName();
		  	myList.add(name);
		 }
		 //setting the file name for the .txt file 
		 File dir = new File(load+" OrderedNames.txt");
		 
		 // printing title to the file 
	       try
	       (FileWriter file = new FileWriter(dir.getAbsoluteFile());
	          PrintWriter writer = new PrintWriter(file); ){
	     
	       writer.println("\t\t******Ordered Names******");
	       writer.println();
	       
	        //sorting Array
			 Collections.sort(myList);
	       //for loop to go through the temp array and print each element to the file line by line
	       for (int i =0; i< myList.size();i++) {
	   
	  	   writer.println(myList.get(i));
	  	   }
	       }
	       catch (IOException e)
	       {
	    	   Alert alert = new Alert(Alert.AlertType.WARNING);
                   alert.setTitle("Writing .txt file");
                   alert.setHeaderText(null);
                   alert.setContentText("ERROR WHEN WRITING FILE!");
                   alert.showAndWait(); 
	       }
         }
	 // method to ready arraylist and write it to a .dot file to be read with graphviz 
    public void saveDot(ArrayList <Person> listIn) {
		 //to store relationships that already added
		 ArrayList<String> graphCheck = new ArrayList<>();
		 //using this to access code 
		 boolean test;
		 
		 //setting file name when saved
		 File dir = new File(load+".dot");
		 	
		 // writing first 4 lines of the file which dont need to change. 
		try (FileWriter file = new FileWriter(dir.getAbsoluteFile());
                    PrintWriter writer = new PrintWriter(file); ){
		 		
		 	writer.println("digraph GoT {");
			writer.println("rankdir=TB;\r");
			writer.println("size=\"45\"");
			writer.println("node [shape = circle] [fontcolor=black,fontname=Helvetica]");
			     
                    String name, child = null, relationship = null,print;
                    // for loop to run through the array and get the individual elements of
                    //each object and write to the file 
			for (int i =0; i< listIn.size();i++) {
			  		  
			    //String name at position i
			    name = listIn.get(i).getName();
			    	  
			for (int j=0; j<listIn.get(i).getConnection().size(); j++)
                            {
                            test = false;
			    //storing child and relationship to variables
			    child = listIn.get(i).getConnection().get(j).getChild().getName();
                            relationship =listIn.get(i).getConnection().get(j).getRelationship();
                            //Setting relationship to 
			    if (relationship.equals("Husband")||relationship.equals("Wife"))
                            {
			  	relationship="Married";
			  		  }
			// checking array to see if parent and child relationship has already been added.
			for (int k =0; k<graphCheck.size(); k++)
			{
                            if(graphCheck.get(k).equals(child+name.trim()))
			{
                            test=true;
			}
                            
			 }
                        //Switch to set the edge style based on weight(relationship)
                        switch(relationship){
                            case "Ex-Husband":
                                print = "\""+name+"\""+" -> "+"\""+child+"\""
                                +" [label=\""+relationship+"\",style=dotted];"; 
                             break;
                            case "Ex-Wife":
                                print = "\""+name+"\""+" -> "+"\""+child+"\""
                                +" [label=\""+relationship+"\",style=dotted];"; 
                             break; 
                            case"Lover":
                                print = "\""+name+"\""+" -> "+"\""+child+"\""
                                +" [label=\""+relationship+"\",color=red];";
                             break;   
                            default:
                                print = "\""+name+"\""+" -> "+"\""+child+"\""
			  		 +" [label=\""+relationship+"\"];";     
                        }
                          /*if test is false, check the name and colour the node appropriately 
                            print parent, relationship and child and add them to the string array to be
                            checked next time round. 
			  			 */
                            if (test==false) {
                            if(name.contains("Stark")) {
			  	writer.println("node [shape = circle,fontcolor=white"
                                        + ",style=filled,color=\"#A4A397\"]");
			  	writer.println(print);
				graphCheck.add(name+child.trim());
                            }
                            else if (name.contains("Targaryen")){
                                writer.println("node [shape = circle,fontcolor=red,"
                                        + "style=filled,color=\"#000000\"]");
			  	writer.println(print);
			  		graphCheck.add(name+child.trim());
			  			   }
                             else if (name.contains("Baratheon")){
                                writer.println("node [shape = circle,fontcolor=black,"
                                        + "style=filled,color=\"#F1E52C\"]");
			  	writer.println(print);
			  		graphCheck.add(name+child.trim());
			  			   }
                             else if (name.contains("Lannister")){
                                writer.println("node [shape = circle,fontcolor=gold,"
                                        + "style=filled,color=\"#ea0b0f\"]");
			  	writer.println(print);
			  		graphCheck.add(name+child.trim());
			  			   }
                              else if (name.contains("Tully")){
                                writer.println("node [shape = circle,fontcolor=red,"
                                        + "style=filled,color=\"#2264b4\"]");
			  	writer.println(print);
			  		graphCheck.add(name+child.trim());
			  			   }
                               else if (name.contains("Arryn")){
                                writer.println("node [shape = circle,fontcolor=white,"
                                        + "style=filled,color=\"#478fe6\"]");
			  	writer.println(print);
			  		graphCheck.add(name+child.trim());
			  			   }
                               else if (name.contains("Greyjoy")){
                                writer.println("node [shape = circle,fontcolor=Yellow,"
                                        + "style=filled,color=\"#5c5c5c\"]");
			  	writer.println(print);
			  		graphCheck.add(name+child.trim());
			  			   }
                               else if (name.contains("Martell")){
                                writer.println("node [shape = circle,fontcolor=red,"
                                        + "style=filled,color=\"#cc8b00\"]");
			  	writer.println(print);
			  		graphCheck.add(name+child.trim());
			  			   }
                                else if (name.contains("Tyrell")){
                                writer.println("node [shape = circle,fontcolor=yellow,"
                                        + "style=filled,color=\"#0ebe52\"]");
			  	writer.println(print);
			  		graphCheck.add(name+child.trim());
			  			   }
                            else {
			  	writer.println(print);
			  	graphCheck.add(name+child.trim());
                            }
			    }
			   }
			  	 }
				 writer.println("}");
		 		}
			  catch (Exception e){
                            Alert alert = new Alert(Alert.AlertType.WARNING);
                            alert.setTitle("Writing .dot file");
                            alert.setHeaderText(null);
                            alert.setContentText("ERROR WHEN WRITING FILE!");
                            alert.showAndWait(); 
				}		 
	 }
         
    public void  saveData()      
    {
        //setting the file name for the .txt file 
        File dir = new File(load+".txt");
        try (FileWriter file = new FileWriter(dir.getAbsoluteFile());
	          PrintWriter writer = new PrintWriter(file); ){
	    
	       //for loop to go through array and print each element to the file line by line
	       for (int i =0; i< treeNav.size();i++) {
	   
	  	   writer.println(treeNav.get(i).getName()+","
                           +treeNav.get(i).getGender()+","
                           +treeNav.get(i).getAlive()+","+
                           treeNav.get(i).getrait());
	  	   } 
               /*loop going through all the nodes and a nest loop gettig relationships 
               and writing them all to a file. 
               */
               for (int i =0; i< treeNav.size();i++){
                   for(int j=0; j<treeNav.get(i).getConnection().size();j++)
                   {
                       /*if statement to make ensure it reads the graph as directed only 
                       so the file keeps the same format and original relationships only*/
                       if (treeNav.get(i).getConnection().get(j).getRelationship().equals("Parent")||
                           treeNav.get(i).getConnection().get(j).getRelationship().equals("Husband")||
                           treeNav.get(i).getConnection().get(j).getRelationship().equals("Father")||
                           treeNav.get(i).getConnection().get(j).getRelationship().equals("Mother"))
                       {
                      writer.println(treeNav.get(i).getConnection().get(j).getParent().getName()
                      +","+treeNav.get(i).getConnection().get(j).getRelationship()+
                              ","+treeNav.get(i).getConnection().get(j).getChild().getName());
                   }
                   }
	       }
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Saved Successfully");
                alert.setHeaderText(null);
                alert.setContentText("Changes Saved!");
                alert.showAndWait();
        }
        
        catch (Exception e)
        {
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Saving file");
           alert.setHeaderText(null);
           alert.setContentText("ERROR WHEN SAVING FILE!");
           alert.showAndWait();
        }
    }
    
    public void update()
    {    
       update.setDisable(true);
       try{
        /*Checking all fields have been filled, if not a alert is
        shown to the user.*/
        if (name.getText().isEmpty() || gender.getText().isEmpty()||
            alive.getText().isEmpty() || trait.getText().isEmpty())          
        {
        //Alert to let the user know all fields have not been filled. 
            new Alert(Alert.AlertType.WARNING, "Please enter all fields")
                 .showAndWait();
        }
        else 
        {
         
       //getting the selected Person from the listview
       String selected = listView.getSelectionModel().getSelectedItem().toString();
       //finding them in the Hashmap
       String nameLookUp = tree.get(selected).getName();
       
       //updating the person with what is in the textFeilds entered by the user
       tree.get(nameLookUp).setName(name.getText().trim());
       tree.get(nameLookUp).setGender(gender.getText().trim());
       tree.get(nameLookUp).setAlive(alive.getText().trim());
       tree.get(nameLookUp).setTrait(trait.getText().trim());
       
          //running the save method
          saveData();
          //clearing the Array, the text areas and combo boxes
          treeNav.clear();
          relationship.clear();
          relationshipAnswer.clear();
          name1.getSelectionModel().clearSelection();
          name2.getSelectionModel().clearSelection();
          /*reloading the last selected house into the system, This will update
          the view to the user with the chaged info of the person. 
          */
          loadData(load+".txt");
          load2();
        }
       }
        catch(Exception e){
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.setTitle("Updating file");
           alert.setHeaderText(null);
           alert.setContentText("ERROR WHEN UPDATING FILE!");
           alert.showAndWait();
                } 
    } 
}
