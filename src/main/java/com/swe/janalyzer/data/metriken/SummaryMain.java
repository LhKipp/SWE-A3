import java.util.List;
import java.util.Map;

import Summary;

public class SummaryMain {
	public static void main(String[] args) {
    
		// 1. Projekt Ordner: preferences
		
		// EditorPreferenceFragment.java
		FileMetrics editorPreferenceFragment = new FileMetrics(Testdateien/preferences/EditorPreferenceFragment.java);
    editorPreferenceFragment.setSLOC(71); //SLOC der Gesamten Datei
    
    ClassMetrics editorPreferenceFragment = new ClassMetrics(); 
		editorPreferenceFragment.setDit(2); // Dit Wert der Klasse
		
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs1 = new ArrayList<FunctionCC>();
	  //Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gezählt
		FunctionCC constrCallOnPreferenceChangeListener1 = new FunctionCC(OnPreferenceChangeListener, 12);
		FunctionCC funconCreate1 = new FunctionCC(onCreate,18);
		FunctionCC funcgetTitle1 = new FunctionCC(getTitle,1);
		// definierte Funktionen der Liste hinzufügen
		functionCCs1.add(constrCallOnPreferenceChangeListener1);
		functionCCs1.add(funconCreate1);
		functionCCs1.add(funcgetTitle1);
		
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		editorPreferenceFragment.setFunctionCCs(functionCCs1);

		
		// ----------------------------------------------------
		
		
		// EditorSHColorSchemePreferenceFragment.java
		FileMetrics editorSHColorSchemePreferenceFragment = new FileMetrics(Testdateien/preferences/EditorSHColorSchemePreferenceFragment.java);
		editorSHColorSchemePreferenceFragment.setSLOC(172);
		
		ClassMetrics editorSHColorSchemePreferenceFragment = new ClassMetrics();
		editorSHColorSchemePreferenceFragment.setDit(2);
		
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs2 = new ArrayList<FunctionCC>();
	  //Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gezählt (gilt für die nächsten zwei)
		FunctionCC constrCallOnPreferenceChangeListener2 = new FunctionCC(OnPreferenceChangeListener, 19);
		FunctionCC constrCallOnPreferenceClickListener1 = new FunctionCC(OnPreferenceClickListener, 5);
		FunctionCC funconCreate2 = new FunctionCC(onCreate, 9);
		FunctionCC funcgetTitle2 = new FunctionCC(getTitle, 1);
		FunctionCC funcloadDefaultColorScheme = new FunctionCC(loadDefaultColorScheme, 18);
		FunctionCC funcsetColorScheme = new FunctionCC(setColorScheme, 10);
		FunctionCC funcisColorSchemePreference = new FunctionCC(isColorSchemePreference, 9);
		FunctionCC functoColorShemeArray = new FunctionCC(toColorShemeArray, 12);
		FunctionCC functoColorSchemeSet = new FunctionCC(toColorSchemeSet, 12);
		// definierte Funktionen der Liste hinzufügen
		functionCCs2.add(constrCallOnPreferenceChangeListener2);
		functionCCs2.add(constrCallOnPreferenceClickListener1);
		functionCCs2.add(funconCreate2);
		functionCCs2.add(funcgetTitle2);
		functionCCs2.add(funcloadDefaultColorScheme);
		functionCCs2.add(funcsetColorScheme);
		functionCCs2.add(funcisColorSchemePreference);
		functionCCs2.add(functoColorShemeArray);
		functionCCs2.add(functoColorSchemeSet);

		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		editorSHColorSchemePreferenceFragment.setFunctionCCs(functionCCs2);

		
		// ----------------------------------------------------

		
		// GeneralPreferenceFragment.java
		FileMetrics generalPreferenceFragment = new FileMetrics(Testdateien/preferences/GeneralPreferenceFragment.java);
		generalPreferenceFragment.setSLOC(201);
		
		ClassMetrics generalPreferenceFragment = new ClassMetrics();
		generalPreferenceFragment.setDit(2);
		
	  // Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs3 = new ArrayList<FunctionCC>();
	  //Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gezählt
		FunctionCC constrCallOnPreferenceChangeListener3 = new FunctionCC(OnPreferenceChangeListener, 68);
		FunctionCC funconCreate3 = new FunctionCC(onCreate, 65);
		FunctionCC funcupdateAccessModeStatus = new FunctionCC(onupdateAccessModeStatusCreate, 10);
		FunctionCC funcgetTitle3 = new FunctionCC(getTitle, 1);
	  // definierte Funktionen der Liste hinzufügen
		functionCCs3.add(constrCallOnPreferenceChangeListener3);
		functionCCs3.add(funconCreate3);
		functionCCs3.add(funcupdateAccessModeStatus);
		functionCCs3.add(funcgetTitle3);
		
	  // setzen der funcCC Liste bei dem ClassMetrics Objekt
		generalPreferenceFragment.setFunctionCCs(functionCCs3);
		
	 	
	  // ----------------------------------------------------
		
		
		// SearchPreferenceFragment.java
		FileMetrics searchPreferenceFragment = new FileMetrics(Testdateien/preferences/SearchPreferenceFragment.java);
		searchPreferenceFragment.setSLOC(121);
		
		ClassMetrics searchPreferenceFragment = new ClassMetrics();
		searchPreferenceFragment.setDit(2);
		
	  // Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs4 = new ArrayList<FunctionCC>();
		//Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gezählt (gilt für die nächsten zwei)
		FunctionCC constrCallOnPreferenceChangeListener4 = new FunctionCC(OnPreferenceChangeListener, 25);
		FunctionCC constrCallOnPreferenceClickListener2 = new FunctionCC(OnPreferenceClickListener, 8);
		FunctionCC funconCreate4 = new FunctionCC(onCreate, 27);
		FunctionCC funcclearRecentSearchTerms = new FunctionCC(clearRecentSearchTerms, 4);		
		FunctionCC funcgetTitle4 = new FunctionCC(getTitle, 1);
	  // definierte Funktionen der Liste hinzufügen
	  functionCCs4.add(constrCallOnPreferenceChangeListener4);
	  functionCCs4.add(constrCallOnPreferenceClickListener2);
	  functionCCs4.add(funconCreate4);
	  functionCCs4.add(funcclearRecentSearchTerms);
	  functionCCs4.add(funcgetTitle4);
	  
	  // setzen der funcCC Liste bei dem ClassMetrics Objekt
	  searchPreferenceFragment.setFunctionCCs(functionCCs4);
	  
	  
	  // ----------------------------------------------------

		
		// SettingsPreferences.java
		FileMetrics settingsPreferences = new FileMetrics(Testdateien/preferences/SettingsPreferences.java);
		settingsPreferences.setSLOC(118);
		
		ClassMetrics settingsPreferences = new ClassMetrics();
		settingsPreferences.setDit(1);
		
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs5 = new ArrayList<FunctionCC>();
	  //Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gezählt
		FunctionCC constrCallBroadcastReceiver1 = new FunctionCC(BroadcastReceiver, 5);
		FunctionCC funconCreate5 = new FunctionCC(onCreate, 10);
		FunctionCC funconDestroy = new FunctionCC(onDestroy, 4);
		FunctionCC funcinitTitleActionBar = new FunctionCC(initTitleActionBar, 16);
		FunctionCC funconBuildHeaders = new FunctionCC(onBuildHeaders, 5);
		FunctionCC funconOptionsItemSelected = new FunctionCC(onOptionsItemSelected, 7);
		FunctionCC funconAttachFragment = new FunctionCC(onAttachFragment, 7);
		FunctionCC funconResume1 = new FunctionCC(onResume, 2);
		FunctionCC funcapplyTheme = new FunctionCC(applyTheme, 9);
		FunctionCC funcisValidFragment = new FunctionCC(isValidFragment, 0);
	  // definierte Funktionen der Liste hinzufügen
		functionCCs5.add(constrCallBroadcastReceiver1);
		functionCCs5.add(funconCreate5);
		functionCCs5.add(funconDestroy);
		functionCCs5.add(funcinitTitleActionBar);
		functionCCs5.add(funconBuildHeaders);
		functionCCs5.add(funconOptionsItemSelected);
		functionCCs5.add(funconAttachFragment);
		functionCCs5.add(funconResume1);
		functionCCs5.add(funcapplyTheme);
		functionCCs5.add(funcisValidFragment);
		
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		settingsPreferences.setFunctionCCs(functionCCs5);
		
	  // ----------------------------------------------------

		
		// StoragePreferenceFragment.java
		FileMetrics storagePreferenceFragment = new FileMetrics(Testdateien/preferences/StoragePreferenceFragment.java);
		storagePreferenceFragment.setSLOC(113);
		
		ClassMetrics storagePreferenceFragment = new ClassMetrics();
		storagePreferenceFragment.setDit(2);
		
	  // Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs6 = new ArrayList<FunctionCC>();
		//Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gezählt (gilt für die nächsten drei)
		FunctionCC constrCallBroadcastReceiver2 = new FunctionCC(BroadcastReceiver, 4);
		FunctionCC constrCallOnPreferenceChangeListener5 = new FunctionCC(OnPreferenceChangeListener, 6);
		FunctionCC funconStart = new FunctionCC(onStart, 5);
		FunctionCC funconStop = new FunctionCC(onStop, 3);
		FunctionCC funconResume2 = new FunctionCC(onStop, 2);
		FunctionCC funconPause = new FunctionCC(onPause, 1);
		FunctionCC funconCreate6 = new FunctionCC(onCreate, 14);
		FunctionCC funcgetTitle5 = new FunctionCC(getTitle, 1);
		FunctionCC funcgetSecureConsole = new FunctionCC(getSecureConsole, 5);
		FunctionCC funcupdatePreferences = new FunctionCC(updatePreferences, 7);
	  // definierte Funktionen der Liste hinzufügen
	  functionCCs6.add(constrCallBroadcastReceiver2);
	  functionCCs6.add(constrCallOnPreferenceChangeListener5);
	  functionCCs6.add(funconStart);
	  functionCCs6.add(funconStop);
	  functionCCs6.add(funconResume2);
	  functionCCs6.add(funconPause);
	  functionCCs6.add(funconCreate6);
	  functionCCs6.add(funcgetTitle5);
	  functionCCs6.add(funcgetSecureConsole);
	  functionCCs6.add(funcupdatePreferences);
	  
	  // setzen der funcCC Liste bei dem ClassMetrics Objekt
	  storagePreferenceFragment.setFunctionCCs(functionCCs6);
	  
	  
	  // ----------------------------------------------------

		
		// TitlePreferenceFragment.java
		FileMetrics titlePreferenceFragment = new FileMetrics(Testdateien/preferences/TitlePreferenceFragment.java);
		titlePreferenceFragment.setSLOC(5);
		
		ClassMetrics titlePreferenceFragment = new ClassMetrics();
		titlePreferenceFragment.setDit(1);
	  
		// Funktionen der Klasse in einer Arraylist / Leer => WMC 0
		//ArrayList<FunctionCC> functionCCs7 = new ArrayList<FunctionCC>();
		titlePreferenceFragment.setFunctionCCs(null); //NULL richtig?

		
		// Projekt Preferences Objekt:
		Summary projektPreferences = new Summary();
		
		List<FileMetrics> fileMetrics1= new List<FileMetrics>();
		fileMetrics1.add(editorPreferenceFragment);
		fileMetrics1.add(editorSHColorSchemePreferenceFragment);
		fileMetrics1.add(generalPreferenceFragment);
		fileMetrics1.add(searchPreferenceFragment);
		fileMetrics1.add(settingsPreferences);
		fileMetrics1.add(storagePreferenceFragment);
		fileMetrics1.add(titlePreferenceFragment);
		
  	projektPreferences.setFileMetrics(fileMetrics1);
  	
  	Map<ClassSpecifier, ClassMetrics> classMetrics1 = new Map<ClassSpecifier, ClassMetrics>();
  	classMetrics1.put(editorPreferenceFragment, editorPreferenceFragment);
  	classMetrics1.put(editorSHColorSchemePreferenceFragment, editorSHColorSchemePreferenceFragment);
  	classMetrics1.put(generalPreferenceFragment, generalPreferenceFragment);
  	classMetrics1.put(searchPreferenceFragment, searchPreferenceFragment);
  	classMetrics1.put(settingsPreferences, settingsPreferences);
  	classMetrics1.put(storagePreferenceFragment, storagePreferenceFragment);
  	classMetrics1.put(titlePreferenceFragment, titlePreferenceFragment);
  	
  	projektPreferences.setClassMetrics(classMetrics1);
  	
  	
  	
  	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    // 2. Projekt Ordner: Graphs
  	
  	// BellmanFord.java
 		FileMetrics Proj2File1 = new FileMetrics(Testdateien/Graphs/BellmanFord.java);
 		Proj2File1.setSLOC(134);
     
    ClassMetrics Proj2File1Class1 = new ClassMetrics();
    Proj2File1Class1.setDit(0);
 		
 		// Funktionen der Klasse in einer Arraylist
 		ArrayList<FunctionCC> Proj2File1Class1functionCCs = new ArrayList<FunctionCC>();
 		FunctionCC proj2File1Class1funcCC1 = new FunctionCC(BellmanFord, 1);
 		FunctionCC proj2File1Class1funcCC2 = new FunctionCC(printPath, 3);
 		FunctionCC proj2File1Class1funcCC3 = new FunctionCC(main, 2);
 		FunctionCC proj2File1Class1funcCC4 = new FunctionCC(go, 27);
 		FunctionCC proj2File1Class1funcCC5 = new FunctionCC(show, 15);
 		FunctionCC proj2File1Class1funcCC6 = new FunctionCC(addEdge, 1);
 		FunctionCC proj2File1Class1funcCC7 = new FunctionCC(getEdgeArray, 0);
 			
 		// definierte Funktionen der Liste hinzufügen
 		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC1);
 		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC2);
 		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC3);
 		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC4);
 		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC5);
 		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC6);
 		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC7);
 		
 		// setzen der funcCC Liste bei dem ClassMetrics Objekt
 		Proj2File1Class1.setFunctionCCs(Proj2File1Class1functionCCs);
 		
 		
 			// Klasse(Class Edge) in Klasse BellmanFord
			ClassMetrics Proj2File1Class2 = new ClassMetrics();
			Proj2File1Class2.setDit(0);
			Proj2File1Class2.setFunctionCCs(null);

 		
 		// ----------------------------------------------------
 		
 		
    // ConnectedComponent.java
 		FileMetrics Proj2File2 = new FileMetrics(Testdateien/Graphs/ConnectedComponent.java);
 		Proj2File2.setSLOC(64);
     
    ClassMetrics Proj2File2Class1 = new ClassMetrics(); //Class Graph
    Proj2File2Class1.setDit(1);
    	ClassMetrics Proj2File2Class2 = new ClassMetrics(); //Class Node
    	Proj2File2Class2.setDit(0);
    	ClassMetrics Proj2File2Class3 = new ClassMetrics(); //Class Edge
    	Proj2File2Class2.setDit(0);
    	
 		// Funktionen der Klasse in einer Arraylist
 		ArrayList<FunctionCC> Proj2File2Class1functionCCs = new ArrayList<FunctionCC>();
 		FunctionCC proj2File2Class1funcCC1 = new FunctionCC(Graph, 2);
 		FunctionCC proj2File2Class1funcCC2 = new FunctionCC(addEdge, 13);
 		FunctionCC proj2File2Class1funcCC3 = new FunctionCC(countGraphs, 6);
 		FunctionCC proj2File2Class1funcCC4 = new FunctionCC(depthFirstSearch, 6);
 		
 		// definierte Funktionen der Liste hinzufügen
 		Proj2File2Class1functionCCs.add(proj2File2Class1funcCC1);
 		Proj2File2Class1functionCCs.add(proj2File2Class1funcCC2);
 		Proj2File2Class1functionCCs.add(proj2File2Class1funcCC3);
 		Proj2File2Class1functionCCs.add(proj2File2Class1funcCC4);
 		
 		// setzen der funcCC Liste bei dem ClassMetrics Objekt
 		Proj2File2Class1.setFunctionCCs(Proj2File2Class1functionCCs);
 		Proj2File2Class2.setFunctionCCs(null);
 		Proj2File2Class3.setFunctionCCs(null);
 		
 		
    // ----------------------------------------------------
 		
 		
    // Cycles.java
 		FileMetrics Proj2File3 = new FileMetrics(Testdateien/Graphs/Cycles.java);
 		Proj2File3.setSLOC(73);
     
    ClassMetrics Proj2File3Class1 = new ClassMetrics(); //1 Konstruktoraufruf außerhalb der Methode
    Proj2File3Class1.setDit(0);
    
    	
 		// Funktionen der Klasse Cycles in einer Arraylist
 		ArrayList<FunctionCC> Proj2File3Class1functionCCs = new ArrayList<FunctionCC>();
 		FunctionCC proj2File3Class1funcCC1 = new FunctionCC(main, 3);
    
 		// definierte Funktionen der Liste hinzufügen
  	Proj2File3Class1functionCCs.add(proj2File3Class1funcCC1);	
  	
    // setzen der funcCC Liste bei dem ClassMetrics Objekt
  	Proj2File3Class1.setFunctionCCs(Proj2File3Class1functionCCs);
 			
  	
  		ClassMetrics Proj2File3Class2 = new ClassMetrics(); //Class Cycle (befindet sich in Klasse Cycles)
  		Proj2File3Class2.setDit(0);
  		
 		  // Func. von Klasse Cycle 
 			ArrayList<FunctionCC> Proj2File3Class2functionCCs = new ArrayList<FunctionCC>();
 			FunctionCC proj2File3Class2funcCC1 = new FunctionCC(Cycle, 12);
 			FunctionCC proj2File3Class2funcCC2 = new FunctionCC(start, 4);
 			FunctionCC proj2File3Class2funcCC3 = new FunctionCC(dfs, 12);
 			FunctionCC proj2File3Class2funcCC4 = new FunctionCC(printAll, 5);
 	    // definierte Funktionen der Liste hinzufügen
 			Proj2File3Class2functionCCs.add(proj2File3Class2funcCC1);
 			Proj2File3Class2functionCCs.add(proj2File3Class2funcCC2);
 			Proj2File3Class2functionCCs.add(proj2File3Class2funcCC3);
 			Proj2File3Class2functionCCs.add(proj2File3Class2funcCC4);
 	    // setzen der funcCC Liste bei dem ClassMetrics Objekt
 			Proj2File3Class2.setFunctionCCs(Proj2File3Class2functionCCs);
 			
 			
 	  // ----------------------------------------------------
 	 		
 	 		
 	  // FloydWarshall.java
 	 	FileMetrics Proj2File4 = new FileMetrics(Testdateien/Graphs/FloydWarshall.java);
 	 	Proj2File4.setSLOC(65);
 	 		
 	 	ClassMetrics Proj2File4Class1 = new ClassMetrics();
    Proj2File4Class1.setDit(0);
    
    // Funktionen der Klasse in einer Arraylist
  	ArrayList<FunctionCC> Proj2File4Class1functionCCs = new ArrayList<FunctionCC>();
  	FunctionCC proj2File4Class1funcCC1 = new FunctionCC(FloydWarshall, 2);
  	FunctionCC proj2File4Class1funcCC2 = new FunctionCC(floydwarshall, 14);
  	FunctionCC proj2File4Class1funcCC3 = new FunctionCC(main, 14);
    // definierte Funktionen der Liste hinzufügen
   	Proj2File4Class1functionCCs.add(proj2File4Class1funcCC1);	
   	Proj2File4Class1functionCCs.add(proj2File4Class1funcCC2);
   	Proj2File4Class1functionCCs.add(proj2File4Class1funcCC3);
    // setzen der funcCC Liste bei dem ClassMetrics Objekt
  	Proj2File4Class1.setFunctionCCs(Proj2File4Class1functionCCs);
  	
  	
    // ----------------------------------------------------
	 		
	 		
 	  // Graphs.java
 	 	FileMetrics Proj2File5 = new FileMetrics(Testdateien/Graphs/Graphs.java);
 	 	Proj2File5.setSLOC(94);
 	 		
 	 	ClassMetrics Proj2File5Class1 = new ClassMetrics(); //Class Graphs
    Proj2File5Class1.setDit(0);
    
    // Funktionen der Klasse in einer Arraylist
   	ArrayList<FunctionCC> Proj2File5Class1functionCCs = new ArrayList<FunctionCC>();
   	FunctionCC proj2File5Class1funcCC1 = new FunctionCC(main, 10);
    // definierte Funktionen der Liste hinzufügen
   	Proj2File5Class1functionCCs.add(proj2File5Class1funcCC1);	
    // setzen der funcCC Liste bei dem ClassMetrics Objekt
   	Proj2File5Class1.setFunctionCCs(Proj2File5Class1functionCCs);
   	
   	
   	ClassMetrics Proj2File5Class2 = new ClassMetrics(); //Class AdjacencyListGraph
    Proj2File5Class2.setDit(1);
    // Funktionen der Klasse in einer Arraylist
   	ArrayList<FunctionCC> Proj2File5Class2functionCCs = new ArrayList<FunctionCC>();
   	FunctionCC proj2File5Class2funcCC1 = new FunctionCC(AdjacencyListGraph, 1);
   	FunctionCC proj2File5Class2funcCC2 = new FunctionCC(removeEdge, 5);
   	FunctionCC proj2File5Class2funcCC3 = new FunctionCC(addEdge, 13);
   	FunctionCC proj2File5Class2funcCC4 = new FunctionCC(toString, 11);
   	// definierte Funktionen der Liste hinzufügen
   	Proj2File5Class2functionCCs.add(proj2File5Class2funcCC1);	
   	Proj2File5Class2functionCCs.add(proj2File5Class2funcCC2);	
   	Proj2File5Class2functionCCs.add(proj2File5Class2funcCC3);	
   	Proj2File5Class2functionCCs.add(proj2File5Class2funcCC4);	
    // setzen der funcCC Liste bei dem ClassMetrics Objekt
   	Proj2File5Class2.setFunctionCCs(Proj2File5Class2functionCCs);
   	
   	
      ClassMetrics Proj2File5Class3 = new ClassMetrics(); // class Vertex innerhalb Class AdjacencyListGraph
   		Proj2File5Class3.setDit(0);
   		// Funktionen der Klasse in einer Arraylist
   		ArrayList<FunctionCC> Proj2File5Class3functionCCs = new ArrayList<FunctionCC>();
   		FunctionCC proj2File5Class3funcCC1 = new FunctionCC(Vertex, 1);
   		FunctionCC proj2File5Class3funcCC2 = new FunctionCC(addAdjacentVertex, 4);
   		FunctionCC proj2File5Class3funcCC3 = new FunctionCC(removeAdjacentVertex, 6);
      // definierte Funktionen der Liste hinzufügen
     	Proj2File5Class3functionCCs.add(proj2File5Class3funcCC1);	
     	Proj2File5Class3functionCCs.add(proj2File5Class3funcCC2);	
     	Proj2File5Class3functionCCs.add(proj2File5Class3funcCC3);
      // setzen der funcCC Liste bei dem ClassMetrics Objekt
      Proj2File5Class3.setFunctionCCs(Proj2File5Class3functionCCs);

    	
    // ----------------------------------------------------
    
      
    // MatrixGraphs.java   
    FileMetrics Proj2File6 = new FileMetrics(Testdateien/Graphs/MatrixGraphs.java);
   	Proj2File6.setSLOC(103);
   	 		
   	ClassMetrics Proj2File6Class1 = new ClassMetrics();
    Proj2File6Class1.setDit(0);
    
    // Funktionen der Klasse in einer Arraylist
   	ArrayList<FunctionCC> Proj2File6Class1functionCCs = new ArrayList<FunctionCC>();
   	FunctionCC proj2File6Class1funcCC1 = new FunctionCC(main, 10);
    // definierte Funktionen der Liste hinzufügen
   	Proj2File6Class1functionCCs.add(proj2File6Class1funcCC1);	
    // setzen der funcCC Liste bei dem ClassMetrics Objekt
   	Proj2File6Class1.setFunctionCCs(Proj2File6Class1functionCCs);
   	
   	ClassMetrics Proj2File6Class2 = new ClassMetrics(); // class AdjacencyMatrixGraph
    Proj2File6Class2.setDit(0);
    // Funktionen der Klasse in einer Arraylist
   	ArrayList<FunctionCC> Proj2File6Class2functionCCs = new ArrayList<FunctionCC>();
   	FunctionCC proj2File6Class2funcCC1 = new FunctionCC(AdjacencyMatrixGraph, 6);
   	FunctionCC proj2File6Class2funcCC2 = new FunctionCC(setNumberOfVertices, 0);
   	FunctionCC proj2File6Class2funcCC3 = new FunctionCC(numberOfVertices, 0);
   	FunctionCC proj2File6Class2funcCC4 = new FunctionCC(setNumberOfEdges, 0);
   	FunctionCC proj2File6Class2funcCC5 = new FunctionCC(numberOfEdges, 0);
   	FunctionCC proj2File6Class2funcCC6 = new FunctionCC(setAdjacency, 0);
   	FunctionCC proj2File6Class2funcCC7 = new FunctionCC(adjacency, 0);
   	FunctionCC proj2File6Class2funcCC8 = new FunctionCC(adjacencyOfEdgeDoesExist, 0);
  	FunctionCC proj2File6Class2funcCC9 = new FunctionCC(vertexDoesExist, 3);
  	FunctionCC proj2File6Class2funcCC10 = new FunctionCC(edgeDoesExist, 4);
  	FunctionCC proj2File6Class2funcCC11 = new FunctionCC(addEdge, 8);
  	FunctionCC proj2File6Class2funcCC12 = new FunctionCC(removeEdge, 8);
  	FunctionCC proj2File6Class2funcCC13 = new FunctionCC(toString, 10);
    // definierte Funktionen der Liste hinzufügen
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC1);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC2);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC3);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC4);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC5);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC6);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC7);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC8);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC9);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC10);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC11);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC12);	
   	Proj2File6Class2functionCCs.add(proj2File6Class2funcCC13);	
    // setzen der funcCC Liste bei dem ClassMetrics Objekt
   	Proj2File6Class2.setFunctionCCs(Proj2File6Class2functionCCs);

  	
    // ----------------------------------------------------
    
    
    // PrimMST.java   
   	FileMetrics Proj2File7 = new FileMetrics(Testdateien/Graphs/PrimMST.java);
   	Proj2File7.setSLOC(50);
   	 		
   	ClassMetrics Proj2File7Class1 = new ClassMetrics();
    Proj2File7Class1.setDit(0);
    
    // Funktionen der Klasse in einer Arraylist
   	ArrayList<FunctionCC> Proj2File7Class1functionCCs = new ArrayList<FunctionCC>();
   	FunctionCC proj2File7Class1funcCC1 = new FunctionCC(minKey, 2);
   	FunctionCC proj2File7Class1funcCC2 = new FunctionCC(printMST, 3);
   	FunctionCC proj2File7Class1funcCC3 = new FunctionCC(primMST, 9);
   	FunctionCC proj2File7Class1funcCC4 = new FunctionCC(main, 3);
    // definierte Funktionen der Liste hinzufügen
   	Proj2File7Class1functionCCs.add(proj2File7Class1funcCC1);
   	Proj2File7Class1functionCCs.add(proj2File7Class1funcCC2);
   	Proj2File7Class1functionCCs.add(proj2File7Class1funcCC3);
   	Proj2File7Class1functionCCs.add(proj2File7Class1funcCC4);
   	
   	
    // Projekt Graphs Objekt:
   	
    Summary projektGraphs = new Summary();
		
		List<FileMetrics> fileMetrics2= new List<FileMetrics>();
		fileMetrics2.add(Proj2File1);
		fileMetrics2.add(Proj2File2);
		fileMetrics2.add(Proj2File3);
		fileMetrics2.add(Proj2File4);
		fileMetrics2.add(Proj2File5);
		fileMetrics2.add(Proj2File6);
		fileMetrics2.add(Proj2File7);
		
		
		projektGraphs.setFileMetrics(fileMetrics2);
  	
		
  	Map<ClassSpecifier, ClassMetrics> classMetrics2 = new Map<ClassSpecifier, ClassMetrics>();
  	classMetrics2.put(BellmanFord, Proj2File1Class1);
  	classMetrics2.put(Edge, Proj2File1Class2);
  	classMetrics2.put(Graph, Proj2File2Class1);
  	classMetrics2.put(Edge2, Proj2File2Class2);
  	classMetrics2.put(Cycles, Proj2File3Class1);
  	classMetrics2.put(Cycle, Proj2File3Class2);
  	classMetrics2.put(FloydWarshall, Proj2File4Class1);
  	classMetrics2.put(Graphs, Proj2File5Class1);
  	classMetrics2.put(AdjacencyListGraph, Proj2File5Class2);
  	classMetrics2.put(Vertex, Proj2File5Class3);
  	classMetrics2.put(MatrixGraphs, Proj2File6Class1);//
  	classMetrics2.put(AdjacencyMatrixGraph, Proj2File6Class2);
  	classMetrics2.put(PrimMST, Proj2File7Class1);
  	
  	projektGraphs.setClassMetrics(classMetrics2);
  	
  	
  	
  	// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
    // 3. Projekt Ordner: Trees
  	
  	// AVLTree.java
  	FileMetrics Proj3File1 = new FileMetrics(Testdateien/Graphs/AVLTree.java);
  	Proj3File1.setSLOC(174);
      
    ClassMetrics Proj3File1Class1 = new ClassMetrics(); //class AVLTree
    Proj3File1Class1.setDit(0);
    
    // Funktionen der Klasse in einer Arraylist
   	ArrayList<FunctionCC> Proj3File1Class1functionCCs = new ArrayList<FunctionCC>();
   	FunctionCC proj3File1Class1funcCC1 = new FunctionCC(insert, 12);
   	FunctionCC proj3File1Class1funcCC2 = new FunctionCC(delete, 12);
   	FunctionCC proj3File1Class1funcCC3 = new FunctionCC(delete, 5); // überladen
   	FunctionCC proj3File1Class1funcCC4 = new FunctionCC(rebalance, 18);
   	FunctionCC proj3File1Class1funcCC5 = new FunctionCC(rotateLeft, 5);
   	FunctionCC proj3File1Class1funcCC6 = new FunctionCC(rotateRight, 5);
   	FunctionCC proj3File1Class1funcCC7 = new FunctionCC(rotateLeftThenRight, 2);
   	FunctionCC proj3File1Class1funcCC8 = new FunctionCC(rotateRightThenLeft, 2);
   	FunctionCC proj3File1Class1funcCC9 = new FunctionCC(height, 1);
   	FunctionCC proj3File1Class1funcCC10 = new FunctionCC(setBalance, 4);
   	FunctionCC proj3File1Class1funcCC11 = new FunctionCC(printBalance, 1);
   	FunctionCC proj3File1Class1funcCC12 = new FunctionCC(printBalance, 4); // überladen
   	FunctionCC proj3File1Class1funcCC13 = new FunctionCC(reheight, 4);
   	FunctionCC proj3File1Class1funcCC14 = new FunctionCC(main, 6);
    // definierte Funktionen der Liste hinzufügen
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC1);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC2);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC3);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC4);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC5);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC6);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC7);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC8);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC9);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC10);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC11);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC12);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC13);
   	Proj3File1Class1functionCCs.add(proj3File1Class1funcCC14);
   	// setzen der funcCC Liste bei dem ClassMetrics Objekt
   	Proj3File1Class1.setFunctionCCs(Proj3File1Class1functionCCs);
   	
   	
   		ClassMetrics Proj3File1Class2 = new ClassMetrics(); //class Node in class AVLTree
   		Proj3File1Class2.setDit(0);
   		Proj3File1Class2.setFunctionCCs(null);
   		
   		
   // ----------------------------------------------------
      
      
   // BinaryTree.java  
   FileMetrics Proj3File2 = new FileMetrics(Testdateien/Graphs/BinaryTree.java);
   Proj3File2.setSLOC(151);
        
   ClassMetrics Proj3File2Class1 = new ClassMetrics(); //class BinaryTree
   Proj3File2Class1.setDit(0);
   // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File2Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File2Class1funcCC1 = new FunctionCC(BinaryTree, 0);
   FunctionCC proj3File2Class1funcCC2 = new FunctionCC(find, 6);
   FunctionCC proj3File2Class1funcCC3 = new FunctionCC(put, 6);
   FunctionCC proj3File2Class1funcCC4 = new FunctionCC(remove, 22);
   FunctionCC proj3File2Class1funcCC5 = new FunctionCC(findSuccessor, 2);
   FunctionCC proj3File2Class1funcCC6 = new FunctionCC(getRoot, 0);
   FunctionCC proj3File2Class1funcCC7 = new FunctionCC(inOrder, 4);
   FunctionCC proj3File2Class1funcCC8 = new FunctionCC(preOrder, 4);
   FunctionCC proj3File2Class1funcCC9 = new FunctionCC(postOrder, 4);
   // definierte Funktionen der Liste hinzufügen
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC1);
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC2);
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC3);
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC4);
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC5);
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC6);
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC7);
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC8);
   Proj3File2Class1functionCCs.add(proj3File2Class1funcCC9);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File2Class1.setFunctionCCs(Proj3File2Class1functionCCs);
   
   
   		ClassMetrics Proj3File2Class2 = new ClassMetrics(); //class Node in class BinaryTree
   		Proj3File2Class2.setDit(0);
   		Proj3File2Class2.setFunctionCCs(null);
		
		
	 // ----------------------------------------------------
	      
	      
	 // GenericTree.java  
	 FileMetrics Proj3File3 = new FileMetrics(Testdateien/Graphs/GenericTree.java);
	 Proj3File3.setSLOC(151);
	        
	 ClassMetrics Proj3File3Class1 = new ClassMetrics(); //class GenericTree
	 Proj3File3Class1.setDit(0);
	 // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File3Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File3Class1funcCC1 = new FunctionCC(GenericTree, 2);
   FunctionCC proj3File3Class1funcCC2 = new FunctionCC(create_treeG, 11);
   FunctionCC proj3File3Class1funcCC3 = new FunctionCC(display, 1);
   FunctionCC proj3File3Class1funcCC4 = new FunctionCC(display_1, 10);
   FunctionCC proj3File3Class1funcCC5 = new FunctionCC(size2call, 1);
   FunctionCC proj3File3Class1funcCC6 = new FunctionCC(size2, 4);
   FunctionCC proj3File3Class1funcCC7 = new FunctionCC(maxcall, 1);
   FunctionCC proj3File3Class1funcCC8 = new FunctionCC(max, 5);
   FunctionCC proj3File3Class1funcCC9 = new FunctionCC(heightcall, 1);
   FunctionCC proj3File3Class1funcCC10 = new FunctionCC(height, 5);
   FunctionCC proj3File3Class1funcCC11 = new FunctionCC(findcall, 1);
   FunctionCC proj3File3Class1funcCC12 = new FunctionCC(find, 5);
   FunctionCC proj3File3Class1funcCC13 = new FunctionCC(depthcaller, 1);
   FunctionCC proj3File3Class1funcCC14 = new FunctionCC(depth, 6);
   FunctionCC proj3File3Class1funcCC15 = new FunctionCC(preordercall, 2);
   FunctionCC proj3File3Class1funcCC16 = new FunctionCC(preorder, 5);
   FunctionCC proj3File3Class1funcCC17 = new FunctionCC(levelorder, 14);
   FunctionCC proj3File3Class1funcCC18 = new FunctionCC(removeleavescall, 1);
   FunctionCC proj3File3Class1funcCC19 = new FunctionCC(removeleaves, 14);
   // definierte Funktionen der Liste hinzufügen
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC1);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC2);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC3);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC4);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC5);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC6);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC7);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC8);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC9);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC10);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC11);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC12);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC13);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC14);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC15);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC16);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC17);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC18);
   Proj3File3Class1functionCCs.add(proj3File3Class1funcCC19);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File3Class1.setFunctionCCs(Proj3File3Class1functionCCs);
   
   		ClassMetrics Proj3File3Class2 = new ClassMetrics(); //class Node in class GenericTree
   		Proj3File3Class2.setDit(0);
   		Proj3File3Class2.setFunctionCCs(null); //enthält 1 Konstruktoraufruf ?!
  		
  		
   // ----------------------------------------------------
   	      
   	      
   // LevelOrderTraversal.java     
   FileMetrics Proj3File4 = new FileMetrics(Testdateien/Graphs/LevelOrderTraversal.java);
   Proj3File4.setSLOC(38);
   	        
   ClassMetrics Proj3File4Class1 = new ClassMetrics(); //class LevelOrderTraversal
   Proj3File4Class1.setDit(0);

   // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File4Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File4Class1funcCC1 = new FunctionCC(LevelOrderTraversal, 0);
   FunctionCC proj3File4Class1funcCC2 = new FunctionCC(printLevelOrder, 3);
   FunctionCC proj3File4Class1funcCC3 = new FunctionCC(height, 5);
   FunctionCC proj3File4Class1funcCC4 = new FunctionCC(printGivenLevel, 6);
   // definierte Funktionen der Liste hinzufügen
   Proj3File4Class1functionCCs.add(proj3File4Class1funcCC1);
   Proj3File4Class1functionCCs.add(proj3File4Class1funcCC2);
   Proj3File4Class1functionCCs.add(proj3File4Class1funcCC3);
   Proj3File4Class1functionCCs.add(proj3File4Class1funcCC4);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File4Class1.setFunctionCCs(Proj3File4Class1functionCCs);
   
   
   		ClassMetrics Proj3File4Class2 = new ClassMetrics(); //class Node in class LevelOrderTraversal
   		Proj3File4Class2.setDit(0);
   		Proj3File4Class2.setFunctionCCs(null);
   			
  		
   // ----------------------------------------------------
   	
   		
   // LevelOrderTraversalQueue.java   
   FileMetrics Proj3File5 = new FileMetrics(Testdateien/Graphs/LevelOrderTraversalQueue.java);
   Proj3File5.setSLOC(29);
      	        
   ClassMetrics Proj3File5Class1 = new ClassMetrics(); //class LevelOrderTraversalQueue
   Proj3File5Class1.setDit(0);	
   // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File5Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File5Class1funcCC1 = new FunctionCC(printLevelOrder, 10);
   // definierte Funktionen der Liste hinzufügen
   Proj3File5Class1functionCCs.add(proj3File5Class1funcCC1);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File5Class1.setFunctionCCs(Proj3File5Class1functionCCs);
   
   		ClassMetrics Proj3File5Class2 = new ClassMetrics(); //class Node in class LevelOrderTraversalQueue
   		Proj3File5Class2.setDit(0);
   		Proj3File5Class2.setFunctionCCs(null);
 			
  		
   // ----------------------------------------------------
      
   		
   // PrintTopViewofTree.java   
   FileMetrics Proj3File6 = new FileMetrics(Testdateien/Graphs/PrintTopViewofTree.java);
   Proj3File6.setSLOC(63);
         	        
   ClassMetrics Proj3File6Class1 = new ClassMetrics(); //class PrintTopViewofTree
   Proj3File6Class1.setDit(0);	   	
   // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File6Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File6Class1funcCC1 = new FunctionCC(main, 9);
   // definierte Funktionen der Liste hinzufügen
   Proj3File6Class1functionCCs.add(proj3File6Class1funcCC1);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File6Class1.setFunctionCCs(Proj3File6Class1functionCCs);  
   
   ClassMetrics Proj3File6Class2 = new ClassMetrics(); //class TreeNode
   Proj3File6Class2.setDit(0);
   Proj3File6Class2.setFunctionCCs(null);  // cc == 0
   
   ClassMetrics Proj3File6Class3 = new ClassMetrics(); //class QItem
   Proj3File6Class3.setDit(0);
   Proj3File6Class3.setFunctionCCs(null);  // cc == 0
   
   ClassMetrics Proj3File6Class4 = new ClassMetrics(); //class Tree
   Proj3File6Class4.setDit(0);
   // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File6Class4functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File6Class4funcCC1 = new FunctionCC(Tree, 0);
   FunctionCC proj3File6Class4funcCC2 = new FunctionCC(Tree, 0);// überladen
   FunctionCC proj3File6Class4funcCC3 = new FunctionCC(printTopView, 18);
   // definierte Funktionen der Liste hinzufügen
   Proj3File6Class4functionCCs.add(proj3File6Class4funcCC1);
   Proj3File6Class4functionCCs.add(proj3File6Class4funcCC2);
   Proj3File6Class4functionCCs.add(proj3File6Class4funcCC3);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File6Class4.setFunctionCCs(Proj3File6Class4functionCCs);
   
		
   // ----------------------------------------------------
      
   		
   // RedBlackBST.java
   FileMetrics Proj3File7 = new FileMetrics(Testdateien/Graphs/RedBlackBST.java);
   Proj3File7.setSLOC(304);
         	        
   ClassMetrics Proj3File7Class1 = new ClassMetrics(); //class RedBlackBST
   Proj3File7Class1.setDit(0);
   // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File7Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File7Class1funcCC1 = new FunctionCC(printTree, 4);
   FunctionCC proj3File7Class1funcCC2 = new FunctionCC(printTreepre, 4);
   FunctionCC proj3File7Class1funcCC3 = new FunctionCC(findNode, 8);
   FunctionCC proj3File7Class1funcCC4 = new FunctionCC(insert, 10);
   FunctionCC proj3File7Class1funcCC5 = new FunctionCC(fixTree, 11);
   FunctionCC proj3File7Class1funcCC6 = new FunctionCC(rotateLeft, 5);
   FunctionCC proj3File7Class1funcCC7 = new FunctionCC(rotateRight, 5);
   FunctionCC proj3File7Class1funcCC8 = new FunctionCC(transplant, 3);
   FunctionCC proj3File7Class1funcCC9 = new FunctionCC(treeMinimum, 1);
   FunctionCC proj3File7Class1funcCC10 = new FunctionCC(delete, 13);
   FunctionCC proj3File7Class1funcCC11 = new FunctionCC(deleteFixup, 17);
   FunctionCC proj3File7Class1funcCC12 = new FunctionCC(insertDemo, 11);
   FunctionCC proj3File7Class1funcCC13 = new FunctionCC(deleteDemo, 14);
   // definierte Funktionen der Liste hinzufügen
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC1);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC2);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC3);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC4);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC5);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC6);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC7);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC8);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC9);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC10);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC11);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC12);
   Proj3File7Class1functionCCs.add(proj3File7Class1funcCC13);
   
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File7Class1.setFunctionCCs(Proj3File7Class1functionCCs);  
   
   	  ClassMetrics Proj3File7Class2 = new ClassMetrics(); //class Node in class RedBlackBST
   	  Proj3File7Class2.setDit(0);
		  Proj3File7Class2.setFunctionCCs(null);

			
	 // ----------------------------------------------------
		      
		   		
	 // TreeTraversal.java
	 FileMetrics Proj3File8 = new FileMetrics(Testdateien/Graphs/TreeTraversal.java);
	 Proj3File8.setSLOC(88);
		         	        
	 ClassMetrics Proj3File8Class1 = new ClassMetrics(); //class TreeTraversal
	 Proj3File8Class1.setDit(0);
	 // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File8Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File8Class1funcCC1 = new FunctionCC(main, 19);
   // definierte Funktionen der Liste hinzufügen
   Proj3File8Class1functionCCs.add(proj3File8Class1funcCC1);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File8Class1.setFunctionCCs(Proj3File8Class1functionCCs);
   
   
   ClassMetrics Proj3File8Class2 = new ClassMetrics(); //class Node
	 Proj3File8Class2.setDit(0);
   // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File8Class2functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File8Class2funcCC1 = new FunctionCC(Node, 0);
   FunctionCC proj3File8Class2funcCC2 = new FunctionCC(insert, 10);
   FunctionCC proj3File8Class2funcCC3 = new FunctionCC(printInOrder, 5);
   FunctionCC proj3File8Class2funcCC4 = new FunctionCC(printPreOrder, 5);
   FunctionCC proj3File8Class2funcCC5 = new FunctionCC(printPostOrder, 5);
   FunctionCC proj3File8Class2funcCC6 = new FunctionCC(printLevelOrder, 10);
   // definierte Funktionen der Liste hinzufügen
   Proj3File8Class2functionCCs.add(proj3File8Class2funcCC1);
   Proj3File8Class2functionCCs.add(proj3File8Class2funcCC2);
   Proj3File8Class2functionCCs.add(proj3File8Class2funcCC3);
   Proj3File8Class2functionCCs.add(proj3File8Class2funcCC4);
   Proj3File8Class2functionCCs.add(proj3File8Class2funcCC5);
   Proj3File8Class2functionCCs.add(proj3File8Class2funcCC6);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File8Class2.setFunctionCCs(Proj3File8Class2functionCCs);
   

	 // ----------------------------------------------------
		      
		   		
	 // TrieImp.java
   FileMetrics Proj3File9 = new FileMetrics(Testdateien/Graphs/TrieImp.java);
	 Proj3File9.setSLOC(119);
		         	        
	 ClassMetrics Proj3File9Class1 = new ClassMetrics(); //class TrieImp
	 Proj3File9Class1.setDit(0);
	 // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File9Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File9Class1funcCC1 = new FunctionCC(TrieImp, 1);
   FunctionCC proj3File9Class1funcCC2 = new FunctionCC(insert, 8);
   FunctionCC proj3File9Class1funcCC3 = new FunctionCC(search, 5);
   FunctionCC proj3File9Class1funcCC4 = new FunctionCC(delete, 6);
   FunctionCC proj3File9Class1funcCC5 = new FunctionCC(sop, 1);
   FunctionCC proj3File9Class1funcCC6 = new FunctionCC(isValid, 1);
   FunctionCC proj3File9Class1funcCC7 = new FunctionCC(main, 45);
   // definierte Funktionen der Liste hinzufügen
   Proj3File9Class1functionCCs.add(proj3File9Class1funcCC1);
   Proj3File9Class1functionCCs.add(proj3File9Class1funcCC2);
   Proj3File9Class1functionCCs.add(proj3File9Class1funcCC3);
   Proj3File9Class1functionCCs.add(proj3File9Class1funcCC4);
   Proj3File9Class1functionCCs.add(proj3File9Class1funcCC5);
   Proj3File9Class1functionCCs.add(proj3File9Class1funcCC6);
   Proj3File9Class1functionCCs.add(proj3File9Class1funcCC7);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File9Class1.setFunctionCCs(Proj3File9Class1functionCCs);
   
   		ClassMetrics Proj3File9Class2 = new ClassMetrics(); //class TrieNode in class TrieImp
   		Proj3File9Class2.setDit(0);
   		ArrayList<FunctionCC> Proj3File9Class2functionCCs = new ArrayList<FunctionCC>();
      FunctionCC proj3File9Class2funcCC1 = new FunctionCC(TrieNode, 1);
      Proj3File9Class2functionCCs.add(proj3File9Class2funcCC1);
   		Proj3File9Class2.setFunctionCCs(Proj3File9Class2functionCCs);
   		

   // ----------------------------------------------------
   		      
   		   		
   // ValidBSTOrNot.java
   FileMetrics Proj3File10 = new FileMetrics(Testdateien/Graphs/ValidBSTOrNot.java);
   Proj3File10.setSLOC(24);
   		         	        
   ClassMetrics Proj3File10Class1 = new ClassMetrics(); //class ValidBSTOrNot
   Proj3File10Class1.setDit(0);
   // Funktionen der Klasse in einer Arraylist
   ArrayList<FunctionCC> Proj3File10Class1functionCCs = new ArrayList<FunctionCC>();
   FunctionCC proj3File10Class1funcCC1 = new FunctionCC(isBST, 1);
   FunctionCC proj3File10Class1funcCC2 = new FunctionCC(isBSTUtil, 4);
   // definierte Funktionen der Liste hinzufügen
   Proj3File10Class1functionCCs.add(proj3File10Class1funcCC1);
   Proj3File10Class1functionCCs.add(proj3File10Class1funcCC2);
   // setzen der funcCC Liste bei dem ClassMetrics Objekt
   Proj3File10Class1.setFunctionCCs(Proj3File10Class1functionCCs);
   
   			ClassMetrics Proj3File10Class2 = new ClassMetrics(); //class Node in class ValidBSTOrNot
   			Proj3File10Class2.setDit(0);
   			Proj3File10Class2.setFunctionCCs(null);
   			
   			
   // Projekt Trees Objekt:
   			
   Summary projektTrees = new Summary();
   			
   List<FileMetrics> fileMetrics3= new List<FileMetrics>();
   fileMetrics3.add(Proj3File1);
   fileMetrics3.add(Proj3File2);
   fileMetrics3.add(Proj3File3);
   fileMetrics3.add(Proj3File4);
   fileMetrics3.add(Proj3File5);
   fileMetrics3.add(Proj3File6);
   fileMetrics3.add(Proj3File7);
   fileMetrics3.add(Proj3File8);
   fileMetrics3.add(Proj3File9);
   fileMetrics3.add(Proj3File10);
   
   projektTrees.setFileMetrics(fileMetrics3);
 	
		
 	Map<ClassSpecifier, ClassMetrics> classMetrics3 = new Map<ClassSpecifier, ClassMetrics>();
 	classMetrics3.put(AVLTree, Proj3File1Class1);
 	classMetrics3.put(Node, Proj3File1Class2);
 	classMetrics3.put(BinaryTree, Proj3File2Class1);
 	classMetrics3.put(Node, Proj2File2Class2);
 	classMetrics3.put(GenericTree, Proj3File3Class1);
 	classMetrics3.put(Node, Proj3File3Class2);
 	classMetrics3.put(LevelOrderTraversal, Proj3File4Class1);
 	classMetrics3.put(Node, Proj3File4Class2);
 	classMetrics3.put(LevelOrderTraversalQueue, Proj3File5Class1);
 	classMetrics3.put(Node, Proj3File5Class2);
 	classMetrics3.put(PrintTopViewofTree, Proj3File6Class1);
 	classMetrics3.put(TreeNode, Proj3File6Class2);
 	classMetrics3.put(QItem, Proj3File6Class3);
 	classMetrics3.put(Tree, Proj2File1Class4);
 	classMetrics3.put(RedBlackBST, Proj3File7Class1);
 	classMetrics3.put(Node, Proj3File7Class2);
 	classMetrics3.put(TreeTraversal, Proj3File8Class1);
 	classMetrics3.put(Node, Proj3File8Class2);
 	classMetrics3.put(TrieImp, Proj3File9Class1);
 	classMetrics3.put(TrieNode, Proj3File9Class2);
 	classMetrics3.put(ValidBSTOrNot, Proj3File10Class1);
 	classMetrics3.put(Node, Proj3File10Class2);
 	
 	projektTrees.setClassMetrics(classMetrics3);
  }
}
