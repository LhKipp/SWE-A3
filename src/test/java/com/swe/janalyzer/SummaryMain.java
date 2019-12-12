package com.swe.janalyzer;

import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.cc.FunctionCC;
import com.swe.janalyzer.util.ClassSpecifier;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class SummaryMain {
	public static Summary getPreferencesSummary() {

		// 1. Projekt Ordner: preferences

		// EditorPreferenceFragment.java
		FileMetrics editorPreferenceFragment = new FileMetrics(Paths.get("Testdateien/preferences/EditorPreferenceFragment.java"));
		editorPreferenceFragment.setSLOC(71); //SLOC der Gesamten Datei

		ClassMetrics editorPreferenceFragmentClass = new ClassMetrics();
		editorPreferenceFragmentClass.setDit(2); // Dit Wert der Klasse

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs1 = new ArrayList<FunctionCC>();
		//Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gez�hlt
		FunctionCC constrCallOnPreferenceChangeListener1 = new FunctionCC("OnPreferenceChangeListener", 12);
		FunctionCC funconCreate1 = new FunctionCC("onCreate", 18);
		FunctionCC funcgetTitle1 = new FunctionCC("getTitle", 1);
		// definierte Funktionen der Liste hinzuf�gen
		functionCCs1.add(constrCallOnPreferenceChangeListener1);
		functionCCs1.add(funconCreate1);
		functionCCs1.add(funcgetTitle1);

		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		editorPreferenceFragmentClass.setFunctionCCs(functionCCs1);


		// ----------------------------------------------------


		// EditorSHColorSchemePreferenceFragment.java
		FileMetrics editorSHColorSchemePreferenceFragment = new FileMetrics(Paths.get("Testdateien/preferences/EditorSHColorSchemePreferenceFragment.java"));
		editorSHColorSchemePreferenceFragment.setSLOC(172);

		ClassMetrics editorSHColorSchemePreferenceFragmentClass = new ClassMetrics();
		editorSHColorSchemePreferenceFragmentClass.setDit(2);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs2 = new ArrayList<FunctionCC>();
		//Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gez�hlt (gilt f�r die n�chsten zwei)
		FunctionCC constrCallOnPreferenceChangeListener2 = new FunctionCC("OnPreferenceChangeListener", 19);
		FunctionCC constrCallOnPreferenceClickListener1 = new FunctionCC("OnPreferenceClickListener", 5);
		FunctionCC funconCreate2 = new FunctionCC("onCreate", 9);
		FunctionCC funcgetTitle2 = new FunctionCC("getTitle", 1);
		FunctionCC funcloadDefaultColorScheme = new FunctionCC("loadDefaultColorScheme", 18);
		FunctionCC funcsetColorScheme = new FunctionCC("setColorScheme", 10);
		FunctionCC funcisColorSchemePreference = new FunctionCC("isColorSchemePreference", 9);
		FunctionCC functoColorShemeArray = new FunctionCC("toColorShemeArray", 12);
		FunctionCC functoColorSchemeSet = new FunctionCC("toColorSchemeSet", 12);
		// definierte Funktionen der Liste hinzuf�gen
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
		editorSHColorSchemePreferenceFragmentClass.setFunctionCCs(functionCCs2);


		// ----------------------------------------------------


		// GeneralPreferenceFragment.java
		FileMetrics generalPreferenceFragment = new FileMetrics(Paths.get("Testdateien/preferences/GeneralPreferenceFragment.java"));
		generalPreferenceFragment.setSLOC(201);

		ClassMetrics generalPreferenceFragmentClass = new ClassMetrics();
		generalPreferenceFragmentClass.setDit(2);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs3 = new ArrayList<FunctionCC>();
		//Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gez�hlt
		FunctionCC constrCallOnPreferenceChangeListener3 = new FunctionCC("OnPreferenceChangeListener", 68);
		FunctionCC funconCreate3 = new FunctionCC("onCreate", 65);
		FunctionCC funcupdateAccessModeStatus = new FunctionCC("onupdateAccessModeStatusCreate", 10);
		FunctionCC funcgetTitle3 = new FunctionCC("getTitle", 1);
		// definierte Funktionen der Liste hinzuf�gen
		functionCCs3.add(constrCallOnPreferenceChangeListener3);
		functionCCs3.add(funconCreate3);
		functionCCs3.add(funcupdateAccessModeStatus);
		functionCCs3.add(funcgetTitle3);

		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		generalPreferenceFragmentClass.setFunctionCCs(functionCCs3);


		// ----------------------------------------------------


		// SearchPreferenceFragment.java
		FileMetrics searchPreferenceFragment = new FileMetrics(Paths.get("Testdateien/preferences/SearchPreferenceFragment.java"));
		searchPreferenceFragment.setSLOC(121);

		ClassMetrics searchPreferenceFragmentClass = new ClassMetrics();
		searchPreferenceFragmentClass.setDit(2);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs4 = new ArrayList<FunctionCC>();
		//Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gez�hlt (gilt f�r die n�chsten zwei)
		FunctionCC constrCallOnPreferenceChangeListener4 = new FunctionCC("OnPreferenceChangeListener", 25);
		FunctionCC constrCallOnPreferenceClickListener2 = new FunctionCC("OnPreferenceClickListener", 8);
		FunctionCC funconCreate4 = new FunctionCC("onCreate", 27);
		FunctionCC funcclearRecentSearchTerms = new FunctionCC("clearRecentSearchTerms", 4);
		FunctionCC funcgetTitle4 = new FunctionCC("getTitle", 1);
		// definierte Funktionen der Liste hinzuf�gen
		functionCCs4.add(constrCallOnPreferenceChangeListener4);
		functionCCs4.add(constrCallOnPreferenceClickListener2);
		functionCCs4.add(funconCreate4);
		functionCCs4.add(funcclearRecentSearchTerms);
		functionCCs4.add(funcgetTitle4);

		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		searchPreferenceFragmentClass.setFunctionCCs(functionCCs4);


		// ----------------------------------------------------


		// SettingsPreferences.java
		FileMetrics settingsPreferences = new FileMetrics(Paths.get("Testdateien/preferences/SettingsPreferences.java"));
		settingsPreferences.setSLOC(118);

		ClassMetrics settingsPreferencesClass = new ClassMetrics();
		settingsPreferencesClass.setDit(1);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs5 = new ArrayList<FunctionCC>();
		//Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gez�hlt
		FunctionCC constrCallBroadcastReceiver1 = new FunctionCC("BroadcastReceiver", 5);
		FunctionCC funconCreate5 = new FunctionCC("onCreate", 10);
		FunctionCC funconDestroy = new FunctionCC("onDestroy", 4);
		FunctionCC funcinitTitleActionBar = new FunctionCC("initTitleActionBar", 16);
		FunctionCC funconBuildHeaders = new FunctionCC("onBuildHeaders", 5);
		FunctionCC funconOptionsItemSelected = new FunctionCC("onOptionsItemSelected", 7);
		FunctionCC funconAttachFragment = new FunctionCC("onAttachFragment", 7);
		FunctionCC funconResume1 = new FunctionCC("onResume", 2);
		FunctionCC funcapplyTheme = new FunctionCC("applyTheme", 9);
		FunctionCC funcisValidFragment = new FunctionCC("isValidFragment", 0);
		// definierte Funktionen der Liste hinzuf�gen
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
		settingsPreferencesClass.setFunctionCCs(functionCCs5);

		// ----------------------------------------------------


		// StoragePreferenceFragment.java
		FileMetrics storagePreferenceFragment = new FileMetrics(Paths.get("Testdateien/preferences/StoragePreferenceFragment.java"));
		storagePreferenceFragment.setSLOC(113);

		ClassMetrics storagePreferenceFragmentClass = new ClassMetrics();
		storagePreferenceFragmentClass.setDit(2);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> functionCCs6 = new ArrayList<FunctionCC>();
		//Methodendefinition im Konstruktoraufruf CC zum Konstruktora. gez�hlt (gilt f�r die n�chsten drei)
		FunctionCC constrCallBroadcastReceiver2 = new FunctionCC("BroadcastReceiver", 4);
		FunctionCC constrCallOnPreferenceChangeListener5 = new FunctionCC("OnPreferenceChangeListener", 6);
		FunctionCC funconStart = new FunctionCC("onStart", 5);
		FunctionCC funconStop = new FunctionCC("onStop", 3);
		FunctionCC funconResume2 = new FunctionCC("onStop", 2);
		FunctionCC funconPause = new FunctionCC("onPause", 1);
		FunctionCC funconCreate6 = new FunctionCC("onCreate", 14);
		FunctionCC funcgetTitle5 = new FunctionCC("getTitle", 1);
		FunctionCC funcgetSecureConsole = new FunctionCC("getSecureConsole", 5);
		FunctionCC funcupdatePreferences = new FunctionCC("updatePreferences", 7);
		// definierte Funktionen der Liste hinzuf�gen
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
		storagePreferenceFragmentClass.setFunctionCCs(functionCCs6);


		// ----------------------------------------------------


		// TitlePreferenceFragment.java
		FileMetrics titlePreferenceFragment = new FileMetrics(Paths.get("Testdateien/preferences/TitlePreferenceFragment.java"));
		titlePreferenceFragment.setSLOC(5);

		ClassMetrics titlePreferenceFragmentClass = new ClassMetrics();
		titlePreferenceFragmentClass.setDit(1);

		// Funktionen der Klasse in einer Arraylist / Leer => WMC 0
		//ArrayList<FunctionCC> functionCCs7 = new ArrayList<FunctionCC>();
		titlePreferenceFragmentClass.setFunctionCCs(new ArrayList<>()); //NULL richtig?


		// Projekt Preferences Objekt:
		Summary projektPreferences = new Summary();

		List<FileMetrics> fileMetrics1 = new ArrayList<FileMetrics>();
		fileMetrics1.add(editorPreferenceFragment);
		fileMetrics1.add(editorSHColorSchemePreferenceFragment);
		fileMetrics1.add(generalPreferenceFragment);
		fileMetrics1.add(searchPreferenceFragment);
		fileMetrics1.add(settingsPreferences);
		fileMetrics1.add(storagePreferenceFragment);
		fileMetrics1.add(titlePreferenceFragment);

		projektPreferences.setFileMetrics(fileMetrics1);

		ClassSpecifier p1Cs1 = new ClassSpecifier("editorPreferenceFragment");
		ClassSpecifier p1Cs2 = new ClassSpecifier("editorSHColorSchemePreferenceFragment");
		ClassSpecifier p1Cs3 = new ClassSpecifier("generalPreferenceFragment");
		ClassSpecifier p1Cs4 = new ClassSpecifier("searchPreferenceFragment");
		ClassSpecifier p1Cs5 = new ClassSpecifier("settingsPreferences");
		ClassSpecifier p1Cs6 = new ClassSpecifier("storagePreferenceFragment");
		ClassSpecifier p1Cs7 = new ClassSpecifier("titlePreferenceFragment");

		Map<ClassSpecifier, ClassMetrics> classMetrics1 = new HashMap<ClassSpecifier, ClassMetrics>();
		classMetrics1.put(p1Cs1, editorPreferenceFragmentClass);
		classMetrics1.put(p1Cs2, editorSHColorSchemePreferenceFragmentClass);
		classMetrics1.put(p1Cs3, generalPreferenceFragmentClass);
		classMetrics1.put(p1Cs4, searchPreferenceFragmentClass);
		classMetrics1.put(p1Cs5, settingsPreferencesClass);
		classMetrics1.put(p1Cs6, storagePreferenceFragmentClass);
		classMetrics1.put(p1Cs7, titlePreferenceFragmentClass);

		projektPreferences.setClassMetrics(classMetrics1);

		return projektPreferences;
	}

	public static Summary getGraphSummary() {
		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// 2. Projekt Ordner: Graphs

		// BellmanFord.java
		FileMetrics Proj2File1 = new FileMetrics(Paths.get("Testdateien/Graphs/BellmanFord.java"));
		Proj2File1.setSLOC(134);

		ClassMetrics Proj2File1Class1 = new ClassMetrics();
		Proj2File1Class1.setDit(0);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj2File1Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File1Class1funcCC1 = new FunctionCC("BellmanFord", 1);
		FunctionCC proj2File1Class1funcCC2 = new FunctionCC("printPath", 4);
		FunctionCC proj2File1Class1funcCC3 = new FunctionCC("main", 3);
		FunctionCC proj2File1Class1funcCC4 = new FunctionCC("go", 27);
		FunctionCC proj2File1Class1funcCC5 = new FunctionCC("show", 14);
		FunctionCC proj2File1Class1funcCC6 = new FunctionCC("addEdge", 2);
		FunctionCC proj2File1Class1funcCC7 = new FunctionCC("getEdgeArray", 1);

		// definierte Funktionen der Liste hinzuf�gen
		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC1);
		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC2);
		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC3);
		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC4);
		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC5);
		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC6);
		Proj2File1Class1functionCCs.add(proj2File1Class1funcCC7);

		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj2File1Class1.setFunctionCCs(Proj2File1Class1functionCCs);


		// Klasse(Class Edge) in Klasse BellmanFord -- gelöscht, da classe doppelt


		// ----------------------------------------------------


		// ConnectedComponent.java
		FileMetrics Proj2File2 = new FileMetrics(Paths.get("Testdateien/Graphs/ConnectedComponent.java"));
		Proj2File2.setSLOC(64);

		ClassMetrics Proj2File2Class1 = new ClassMetrics(); //Class Graph
		Proj2File2Class1.setDit(0);
		

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj2File2Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File2Class1funcCC1 = new FunctionCC("Graph", 3);
		FunctionCC proj2File2Class1funcCC2 = new FunctionCC("addEdge", 14);
		FunctionCC proj2File2Class1funcCC3 = new FunctionCC("countGraphs", 9);
		FunctionCC proj2File2Class1funcCC4 = new FunctionCC("depthFirstSearch", 7);

		// definierte Funktionen der Liste hinzuf�gen
		Proj2File2Class1functionCCs.add(proj2File2Class1funcCC1);
		Proj2File2Class1functionCCs.add(proj2File2Class1funcCC2);
		Proj2File2Class1functionCCs.add(proj2File2Class1funcCC3);
		Proj2File2Class1functionCCs.add(proj2File2Class1funcCC4);

		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj2File2Class1.setFunctionCCs(Proj2File2Class1functionCCs);
		
		
		ClassMetrics Proj2File2Class2 = new ClassMetrics(); //Class Node
		Proj2File2Class2.setDit(0);
		ArrayList<FunctionCC> Proj2File2Class2functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File2Class2funcCC1 = new FunctionCC("Node", 1);
		Proj2File2Class2functionCCs.add(proj2File2Class2funcCC1);
		Proj2File2Class2.setFunctionCCs(Proj2File2Class2functionCCs);
		
		
		ClassMetrics Proj2File2Class3 = new ClassMetrics(); //Class Edge
		Proj2File2Class2.setDit(0);
		ArrayList<FunctionCC> Proj2File2Class3functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File2Class3funcCC1 = new FunctionCC("Edge", 1);
		Proj2File2Class3functionCCs.add(proj2File2Class3funcCC1);
		Proj2File2Class3.setFunctionCCs(Proj2File2Class3functionCCs);


		// ----------------------------------------------------


		// Cycles.java
		FileMetrics Proj2File3 = new FileMetrics(Paths.get("Testdateien/Graphs/Cycles.java"));
		Proj2File3.setSLOC(73);

		ClassMetrics Proj2File3Class1 = new ClassMetrics(); //1 Konstruktoraufruf au�erhalb der Methode
		Proj2File3Class1.setDit(0);


		// Funktionen der Klasse Cycles in einer Arraylist
		ArrayList<FunctionCC> Proj2File3Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File3Class1funcCC1 = new FunctionCC("main", 4);

		// definierte Funktionen der Liste hinzuf�gen
		Proj2File3Class1functionCCs.add(proj2File3Class1funcCC1);

		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj2File3Class1.setFunctionCCs(Proj2File3Class1functionCCs);


		ClassMetrics Proj2File3Class2 = new ClassMetrics(); //Class Cycle (befindet sich in Klasse Cycles)
		Proj2File3Class2.setDit(0);

		// Func. von Klasse Cycle
		ArrayList<FunctionCC> Proj2File3Class2functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File3Class2funcCC1 = new FunctionCC("Cycle", 11); 
		FunctionCC proj2File3Class2funcCC2 = new FunctionCC("start", 5);
		FunctionCC proj2File3Class2funcCC3 = new FunctionCC("dfs", 13); // Unit wirft fail? kalk. 13 else nicht gezählt
		FunctionCC proj2File3Class2funcCC4 = new FunctionCC("printAll", 13);
		// definierte Funktionen der Liste hinzuf�gen
		Proj2File3Class2functionCCs.add(proj2File3Class2funcCC1);
		Proj2File3Class2functionCCs.add(proj2File3Class2funcCC2);
		Proj2File3Class2functionCCs.add(proj2File3Class2funcCC3);
		Proj2File3Class2functionCCs.add(proj2File3Class2funcCC4);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj2File3Class2.setFunctionCCs(Proj2File3Class2functionCCs);


		// ----------------------------------------------------


		// FloydWarshall.java
		FileMetrics Proj2File4 = new FileMetrics(Paths.get("Testdateien/Graphs/FloydWarshall.java"));
		Proj2File4.setSLOC(65);
		

		ClassMetrics Proj2File4Class1 = new ClassMetrics();
		Proj2File4Class1.setDit(0);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj2File4Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File4Class1funcCC1 = new FunctionCC("FloydWarshall", 2);
		FunctionCC proj2File4Class1funcCC2 = new FunctionCC("floydwarshall", 15);
		FunctionCC proj2File4Class1funcCC3 = new FunctionCC("main", 14);
		// definierte Funktionen der Liste hinzuf�gen
		Proj2File4Class1functionCCs.add(proj2File4Class1funcCC1);
		Proj2File4Class1functionCCs.add(proj2File4Class1funcCC2);
		Proj2File4Class1functionCCs.add(proj2File4Class1funcCC3);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj2File4Class1.setFunctionCCs(Proj2File4Class1functionCCs);


		// ----------------------------------------------------


		// Graphs.java
		FileMetrics Proj2File5 = new FileMetrics(Paths.get("Testdateien/Graphs/Graphs.java"));
		Proj2File5.setSLOC(94);

		ClassMetrics Proj2File5Class1 = new ClassMetrics(); //Class Graphs
		Proj2File5Class1.setDit(0);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj2File5Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File5Class1funcCC1 = new FunctionCC("main", 11);
		// definierte Funktionen der Liste hinzuf�gen
		Proj2File5Class1functionCCs.add(proj2File5Class1funcCC1);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj2File5Class1.setFunctionCCs(Proj2File5Class1functionCCs);


		ClassMetrics Proj2File5Class2 = new ClassMetrics(); //Class AdjacencyListGraph
		Proj2File5Class2.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj2File5Class2functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File5Class2funcCC1 = new FunctionCC("AdjacencyListGraph", 2);
		FunctionCC proj2File5Class2funcCC2 = new FunctionCC("removeEdge", 6);
		FunctionCC proj2File5Class2funcCC3 = new FunctionCC("addEdge", 14);
		FunctionCC proj2File5Class2funcCC4 = new FunctionCC("toString", 12);
		// definierte Funktionen der Liste hinzuf�gen
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
		FunctionCC proj2File5Class3funcCC1 = new FunctionCC("Vertex", 2);
		FunctionCC proj2File5Class3funcCC2 = new FunctionCC("addAdjacentVertex", 5);
		FunctionCC proj2File5Class3funcCC3 = new FunctionCC("removeAdjacentVertex", 7);
		// definierte Funktionen der Liste hinzuf�gen
		Proj2File5Class3functionCCs.add(proj2File5Class3funcCC1);
		Proj2File5Class3functionCCs.add(proj2File5Class3funcCC2);
		Proj2File5Class3functionCCs.add(proj2File5Class3funcCC3);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj2File5Class3.setFunctionCCs(Proj2File5Class3functionCCs);


		// ----------------------------------------------------


		// MatrixGraphs.java
		FileMetrics Proj2File6 = new FileMetrics(Paths.get("Testdateien/Graphs/MatrixGraphs.java"));
		Proj2File6.setSLOC(103);

		ClassMetrics Proj2File6Class1 = new ClassMetrics();
		Proj2File6Class1.setDit(0);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj2File6Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File6Class1funcCC1 = new FunctionCC("main", 11);
		// definierte Funktionen der Liste hinzuf�gen
		Proj2File6Class1functionCCs.add(proj2File6Class1funcCC1);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj2File6Class1.setFunctionCCs(Proj2File6Class1functionCCs);

		ClassMetrics Proj2File6Class2 = new ClassMetrics(); // class AdjacencyMatrixGraph
		Proj2File6Class2.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj2File6Class2functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File6Class2funcCC1 = new FunctionCC("AdjacencyMatrixGraph", 7);
		FunctionCC proj2File6Class2funcCC2 = new FunctionCC("setNumberOfVertices", 1);
		FunctionCC proj2File6Class2funcCC3 = new FunctionCC("numberOfVertices", 1);
		FunctionCC proj2File6Class2funcCC4 = new FunctionCC("setNumberOfEdges", 1);
		FunctionCC proj2File6Class2funcCC5 = new FunctionCC("numberOfEdges", 1);
		FunctionCC proj2File6Class2funcCC6 = new FunctionCC("setAdjacency", 1);
		FunctionCC proj2File6Class2funcCC7 = new FunctionCC("adjacency", 1);
		FunctionCC proj2File6Class2funcCC8 = new FunctionCC("adjacencyOfEdgeDoesExist", 2);
		FunctionCC proj2File6Class2funcCC9 = new FunctionCC("vertexDoesExist", 3); // kalk. 3 else nicht gezählt
		FunctionCC proj2File6Class2funcCC10 = new FunctionCC("edgeDoesExist", 5);
		FunctionCC proj2File6Class2funcCC11 = new FunctionCC("addEdge", 10);
		FunctionCC proj2File6Class2funcCC12 = new FunctionCC("removeEdge", 10);
		FunctionCC proj2File6Class2funcCC13 = new FunctionCC("toString", 11);
		// definierte Funktionen der Liste hinzuf�gen
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
		FileMetrics Proj2File7 = new FileMetrics(Paths.get("Testdateien/Graphs/PrimMST.java"));
		Proj2File7.setSLOC(50);

		ClassMetrics Proj2File7Class1 = new ClassMetrics();
		Proj2File7Class1.setDit(0);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj2File7Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj2File7Class1funcCC1 = new FunctionCC("minKey", 3);
		FunctionCC proj2File7Class1funcCC2 = new FunctionCC("printMST", 4);
		FunctionCC proj2File7Class1funcCC3 = new FunctionCC("primMST", 7);
		FunctionCC proj2File7Class1funcCC4 = new FunctionCC("main", 3);
		// definierte Funktionen der Liste hinzuf�gen
		Proj2File7Class1functionCCs.add(proj2File7Class1funcCC1);
		Proj2File7Class1functionCCs.add(proj2File7Class1funcCC2);
		Proj2File7Class1functionCCs.add(proj2File7Class1funcCC3);
		Proj2File7Class1functionCCs.add(proj2File7Class1funcCC4);
		Proj2File7Class1.setFunctionCCs(Proj2File7Class1functionCCs );


		// Projekt Graphs Objekt:

		Summary projektGraphs = new Summary();

		List<FileMetrics> fileMetrics2 = new ArrayList<FileMetrics>();
		fileMetrics2.add(Proj2File1);
		fileMetrics2.add(Proj2File2);
		fileMetrics2.add(Proj2File3);
		fileMetrics2.add(Proj2File4);
		fileMetrics2.add(Proj2File5);
		fileMetrics2.add(Proj2File6);
		fileMetrics2.add(Proj2File7);


		projektGraphs.setFileMetrics(fileMetrics2);


		Map<ClassSpecifier, ClassMetrics> classMetrics2 = new HashMap<ClassSpecifier, ClassMetrics>();

		ClassSpecifier p2Cs1 = new ClassSpecifier("BellmanFord");
		ClassSpecifier p2Cs2 = new ClassSpecifier("Edge");
		ClassSpecifier p2Cs3 = new ClassSpecifier("Graph");
		ClassSpecifier p2Cs4 = new ClassSpecifier("Node");
		ClassSpecifier p2Cs5 = new ClassSpecifier("Edge");
		ClassSpecifier p2Cs6 = new ClassSpecifier("Cycles");
		ClassSpecifier p2Cs7 = new ClassSpecifier("Cycle");
		ClassSpecifier p2Cs8 = new ClassSpecifier("FloydWarshall");
		ClassSpecifier p2Cs9 = new ClassSpecifier("Graphs");
		ClassSpecifier p2Cs10 = new ClassSpecifier("AdjacencyListGraph");
		ClassSpecifier p2Cs11 = new ClassSpecifier("Vertex");
		ClassSpecifier p2Cs12 = new ClassSpecifier("MatrixGraphs");
		ClassSpecifier p2Cs13 = new ClassSpecifier("AdjacencyMatrixGraph");
		ClassSpecifier p2Cs14 = new ClassSpecifier("PrimMST");

		classMetrics2.put(p2Cs1, Proj2File1Class1);
		classMetrics2.put(p2Cs3, Proj2File2Class1);
		classMetrics2.put(p2Cs4, Proj2File2Class2);
		classMetrics2.put(p2Cs5, Proj2File2Class3);
		classMetrics2.put(p2Cs6, Proj2File3Class1);
		classMetrics2.put(p2Cs7, Proj2File3Class2);
		classMetrics2.put(p2Cs8, Proj2File4Class1);
		classMetrics2.put(p2Cs9, Proj2File5Class1);
		classMetrics2.put(p2Cs10, Proj2File5Class2);
		classMetrics2.put(p2Cs11, Proj2File5Class3);
		classMetrics2.put(p2Cs12, Proj2File6Class1);
		classMetrics2.put(p2Cs13, Proj2File6Class2);
		classMetrics2.put(p2Cs14, Proj2File7Class1);

		projektGraphs.setClassMetrics(classMetrics2);

		return projektGraphs;

	}

	public static Summary getTreeSummary(){

		// XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
		// 3. Projekt Ordner: Trees

		// AVLTree.java
		FileMetrics Proj3File1 = new FileMetrics(Paths.get("Testdateien/Trees/AVLTree.java"));
		Proj3File1.setSLOC(174);

		ClassMetrics Proj3File1Class1 = new ClassMetrics(); //class AVLTree
		Proj3File1Class1.setDit(0);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File1Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File1Class1funcCC1 = new FunctionCC("insert", 12);
		FunctionCC proj3File1Class1funcCC2 = new FunctionCC("delete", 12);
		FunctionCC proj3File1Class1funcCC3 = new FunctionCC("delete", 5); // �berladen
		FunctionCC proj3File1Class1funcCC4 = new FunctionCC("rebalance", 18);
		FunctionCC proj3File1Class1funcCC5 = new FunctionCC("rotateLeft", 5);
		FunctionCC proj3File1Class1funcCC6 = new FunctionCC("rotateRight", 5);
		FunctionCC proj3File1Class1funcCC7 = new FunctionCC("rotateLeftThenRight", 2);
		FunctionCC proj3File1Class1funcCC8 = new FunctionCC("rotateRightThenLeft", 2);
		FunctionCC proj3File1Class1funcCC9 = new FunctionCC("height", 1);
		FunctionCC proj3File1Class1funcCC10 = new FunctionCC("setBalance", 4);
		FunctionCC proj3File1Class1funcCC11 = new FunctionCC("printBalance", 1);
		FunctionCC proj3File1Class1funcCC12 = new FunctionCC("printBalance", 4); // �berladen
		FunctionCC proj3File1Class1funcCC13 = new FunctionCC("reheight", 4);
		FunctionCC proj3File1Class1funcCC14 = new FunctionCC("main", 6);
		// definierte Funktionen der Liste hinzuf�gen
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
		Proj3File1Class2.setFunctionCCs(new ArrayList<>());


		// ----------------------------------------------------


		// BinaryTree.java
		FileMetrics Proj3File2 = new FileMetrics(Paths.get("Testdateien/Trees/BinaryTree.java"));
		Proj3File2.setSLOC(151);

		ClassMetrics Proj3File2Class1 = new ClassMetrics(); //class BinaryTree
		Proj3File2Class1.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File2Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File2Class1funcCC1 = new FunctionCC("BinaryTree", 0);
		FunctionCC proj3File2Class1funcCC2 = new FunctionCC("find", 6);
		FunctionCC proj3File2Class1funcCC3 = new FunctionCC("put", 6);
		FunctionCC proj3File2Class1funcCC4 = new FunctionCC("remove", 22);
		FunctionCC proj3File2Class1funcCC5 = new FunctionCC("findSuccessor", 2);
		FunctionCC proj3File2Class1funcCC6 = new FunctionCC("getRoot", 0);
		FunctionCC proj3File2Class1funcCC7 = new FunctionCC("inOrder", 4);
		FunctionCC proj3File2Class1funcCC8 = new FunctionCC("preOrder", 4);
		FunctionCC proj3File2Class1funcCC9 = new FunctionCC("postOrder", 4);
		// definierte Funktionen der Liste hinzuf�gen
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
		Proj3File2Class2.setFunctionCCs(new ArrayList<>());


		// ----------------------------------------------------


		// GenericTree.java
		FileMetrics Proj3File3 = new FileMetrics(Paths.get("Testdateien/Trees/GenericTree.java"));
		Proj3File3.setSLOC(151);

		ClassMetrics Proj3File3Class1 = new ClassMetrics(); //class GenericTree
		Proj3File3Class1.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File3Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File3Class1funcCC1 = new FunctionCC("GenericTree", 2);
		FunctionCC proj3File3Class1funcCC2 = new FunctionCC("create_treeG", 11);
		FunctionCC proj3File3Class1funcCC3 = new FunctionCC("display", 1);
		FunctionCC proj3File3Class1funcCC4 = new FunctionCC("display_1", 10);
		FunctionCC proj3File3Class1funcCC5 = new FunctionCC("size2call", 1);
		FunctionCC proj3File3Class1funcCC6 = new FunctionCC("size2", 4);
		FunctionCC proj3File3Class1funcCC7 = new FunctionCC("maxcall", 1);
		FunctionCC proj3File3Class1funcCC8 = new FunctionCC("max", 5);
		FunctionCC proj3File3Class1funcCC9 = new FunctionCC("heightcall", 1);
		FunctionCC proj3File3Class1funcCC10 = new FunctionCC("height", 5);
		FunctionCC proj3File3Class1funcCC11 = new FunctionCC("findcall", 1);
		FunctionCC proj3File3Class1funcCC12 = new FunctionCC("find", 5);
		FunctionCC proj3File3Class1funcCC13 = new FunctionCC("depthcaller", 1);
		FunctionCC proj3File3Class1funcCC14 = new FunctionCC("depth", 6);
		FunctionCC proj3File3Class1funcCC15 = new FunctionCC("preordercall", 2);
		FunctionCC proj3File3Class1funcCC16 = new FunctionCC("preorder", 5);
		FunctionCC proj3File3Class1funcCC17 = new FunctionCC("levelorder", 14);
		FunctionCC proj3File3Class1funcCC18 = new FunctionCC("removeleavescall", 1);
		FunctionCC proj3File3Class1funcCC19 = new FunctionCC("removeleaves", 14);
		// definierte Funktionen der Liste hinzuf�gen
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
		Proj3File3Class2.setFunctionCCs(new ArrayList<>()); //enth�lt 1 Konstruktoraufruf ?!


		// ----------------------------------------------------


		// LevelOrderTraversal.java
		FileMetrics Proj3File4 = new FileMetrics(Paths.get("Testdateien/Trees/LevelOrderTraversal.java"));
		Proj3File4.setSLOC(38);

		ClassMetrics Proj3File4Class1 = new ClassMetrics(); //class LevelOrderTraversal
		Proj3File4Class1.setDit(0);

		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File4Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File4Class1funcCC1 = new FunctionCC("LevelOrderTraversal", 0);
		FunctionCC proj3File4Class1funcCC2 = new FunctionCC("printLevelOrder", 3);
		FunctionCC proj3File4Class1funcCC3 = new FunctionCC("height", 5);
		FunctionCC proj3File4Class1funcCC4 = new FunctionCC("printGivenLevel", 6);
		// definierte Funktionen der Liste hinzuf�gen
		Proj3File4Class1functionCCs.add(proj3File4Class1funcCC1);
		Proj3File4Class1functionCCs.add(proj3File4Class1funcCC2);
		Proj3File4Class1functionCCs.add(proj3File4Class1funcCC3);
		Proj3File4Class1functionCCs.add(proj3File4Class1funcCC4);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj3File4Class1.setFunctionCCs(Proj3File4Class1functionCCs);


		ClassMetrics Proj3File4Class2 = new ClassMetrics(); //class Node in class LevelOrderTraversal
		Proj3File4Class2.setDit(0);
		Proj3File4Class2.setFunctionCCs(new ArrayList<>());


		// ----------------------------------------------------


		// LevelOrderTraversalQueue.java
		FileMetrics Proj3File5 = new FileMetrics(Paths.get("Testdateien/Trees/LevelOrderTraversalQueue.java"));
		Proj3File5.setSLOC(29);

		ClassMetrics Proj3File5Class1 = new ClassMetrics(); //class LevelOrderTraversalQueue
		Proj3File5Class1.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File5Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File5Class1funcCC1 = new FunctionCC("printLevelOrder", 10);
		// definierte Funktionen der Liste hinzuf�gen
		Proj3File5Class1functionCCs.add(proj3File5Class1funcCC1);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj3File5Class1.setFunctionCCs(Proj3File5Class1functionCCs);

		ClassMetrics Proj3File5Class2 = new ClassMetrics(); //class Node in class LevelOrderTraversalQueue
		Proj3File5Class2.setDit(0);
		Proj3File5Class2.setFunctionCCs(new ArrayList<>());


		// ----------------------------------------------------


		// PrintTopViewofTree.java
		FileMetrics Proj3File6 = new FileMetrics(Paths.get("Testdateien/Trees/PrintTopViewofTree.java"));
		Proj3File6.setSLOC(63);

		ClassMetrics Proj3File6Class1 = new ClassMetrics(); //class PrintTopViewofTree
		Proj3File6Class1.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File6Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File6Class1funcCC1 = new FunctionCC("main", 9);
		// definierte Funktionen der Liste hinzuf�gen
		Proj3File6Class1functionCCs.add(proj3File6Class1funcCC1);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj3File6Class1.setFunctionCCs(Proj3File6Class1functionCCs);

		ClassMetrics Proj3File6Class2 = new ClassMetrics(); //class TreeNode
		Proj3File6Class2.setDit(0);
		Proj3File6Class2.setFunctionCCs(new ArrayList<>());  // cc == 0

		ClassMetrics Proj3File6Class3 = new ClassMetrics(); //class QItem
		Proj3File6Class3.setDit(0);
		Proj3File6Class3.setFunctionCCs(new ArrayList<>());  // cc == 0

		ClassMetrics Proj3File6Class4 = new ClassMetrics(); //class Tree
		Proj3File6Class4.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File6Class4functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File6Class4funcCC1 = new FunctionCC("Tree", 0);
		FunctionCC proj3File6Class4funcCC2 = new FunctionCC("Tree", 0);// ueberladen
		FunctionCC proj3File6Class4funcCC3 = new FunctionCC("printTopView", 18);
		// definierte Funktionen der Liste hinzuf�gen
		Proj3File6Class4functionCCs.add(proj3File6Class4funcCC1);
		Proj3File6Class4functionCCs.add(proj3File6Class4funcCC2);
		Proj3File6Class4functionCCs.add(proj3File6Class4funcCC3);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj3File6Class4.setFunctionCCs(Proj3File6Class4functionCCs);


		// ----------------------------------------------------


		// RedBlackBST.java
		FileMetrics Proj3File7 = new FileMetrics(Paths.get("Testdateien/Trees/RedBlackBST.java"));
		Proj3File7.setSLOC(304);

		ClassMetrics Proj3File7Class1 = new ClassMetrics(); //class RedBlackBST
		Proj3File7Class1.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File7Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File7Class1funcCC1 = new FunctionCC("printTree", 4);
		FunctionCC proj3File7Class1funcCC2 = new FunctionCC("printTreepre", 4);
		FunctionCC proj3File7Class1funcCC3 = new FunctionCC("findNode", 8);
		FunctionCC proj3File7Class1funcCC4 = new FunctionCC("insert", 10);
		FunctionCC proj3File7Class1funcCC5 = new FunctionCC("fixTree", 11);
		FunctionCC proj3File7Class1funcCC6 = new FunctionCC("rotateLeft", 5);
		FunctionCC proj3File7Class1funcCC7 = new FunctionCC("rotateRight", 5);
		FunctionCC proj3File7Class1funcCC8 = new FunctionCC("transplant", 3);
		FunctionCC proj3File7Class1funcCC9 = new FunctionCC("treeMinimum", 1);
		FunctionCC proj3File7Class1funcCC10 = new FunctionCC("delete", 13);
		FunctionCC proj3File7Class1funcCC11 = new FunctionCC("deleteFixup", 17);
		FunctionCC proj3File7Class1funcCC12 = new FunctionCC("insertDemo", 11);
		FunctionCC proj3File7Class1funcCC13 = new FunctionCC("deleteDemo", 14);
		// definierte Funktionen der Liste hinzuf�gen
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
		Proj3File7Class2.setFunctionCCs(new ArrayList<>());


		// ----------------------------------------------------


		// TreeTraversal.java
		FileMetrics Proj3File8 = new FileMetrics(Paths.get("Testdateien/Trees/TreeTraversal.java"));
		Proj3File8.setSLOC(88);

		ClassMetrics Proj3File8Class1 = new ClassMetrics(); //class TreeTraversal
		Proj3File8Class1.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File8Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File8Class1funcCC1 = new FunctionCC("main", 19);
		// definierte Funktionen der Liste hinzuf�gen
		Proj3File8Class1functionCCs.add(proj3File8Class1funcCC1);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj3File8Class1.setFunctionCCs(Proj3File8Class1functionCCs);


		ClassMetrics Proj3File8Class2 = new ClassMetrics(); //class Node
		Proj3File8Class2.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File8Class2functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File8Class2funcCC1 = new FunctionCC("Node", 0);
		FunctionCC proj3File8Class2funcCC2 = new FunctionCC("insert", 10);
		FunctionCC proj3File8Class2funcCC3 = new FunctionCC("printInOrder", 5);
		FunctionCC proj3File8Class2funcCC4 = new FunctionCC("printPreOrder", 5);
		FunctionCC proj3File8Class2funcCC5 = new FunctionCC("printPostOrder", 5);
		FunctionCC proj3File8Class2funcCC6 = new FunctionCC("printLevelOrder", 10);
		// definierte Funktionen der Liste hinzuf�gen
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
		FileMetrics Proj3File9 = new FileMetrics(Paths.get("Testdateien/Trees/TrieImp.java"));
		Proj3File9.setSLOC(119);

		ClassMetrics Proj3File9Class1 = new ClassMetrics(); //class TrieImp
		Proj3File9Class1.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File9Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File9Class1funcCC1 = new FunctionCC("TrieImp", 1);
		FunctionCC proj3File9Class1funcCC2 = new FunctionCC("insert", 8);
		FunctionCC proj3File9Class1funcCC3 = new FunctionCC("search", 5);
		FunctionCC proj3File9Class1funcCC4 = new FunctionCC("delete", 6);
		FunctionCC proj3File9Class1funcCC5 = new FunctionCC("sop", 1);
		FunctionCC proj3File9Class1funcCC6 = new FunctionCC("isValid", 1);
		FunctionCC proj3File9Class1funcCC7 = new FunctionCC("main", 45);
		// definierte Funktionen der Liste hinzuf�gen
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
		FunctionCC proj3File9Class2funcCC1 = new FunctionCC("TrieNode", 1);
		Proj3File9Class2functionCCs.add(proj3File9Class2funcCC1);
		Proj3File9Class2.setFunctionCCs(Proj3File9Class2functionCCs);


		// ----------------------------------------------------


		// ValidBSTOrNot.java
		FileMetrics Proj3File10 = new FileMetrics(Paths.get("Testdateien/Trees/ValidBSTOrNot.java"));
		Proj3File10.setSLOC(24);

		ClassMetrics Proj3File10Class1 = new ClassMetrics(); //class ValidBSTOrNot
		Proj3File10Class1.setDit(0);
		// Funktionen der Klasse in einer Arraylist
		ArrayList<FunctionCC> Proj3File10Class1functionCCs = new ArrayList<FunctionCC>();
		FunctionCC proj3File10Class1funcCC1 = new FunctionCC("isBST", 1);
		FunctionCC proj3File10Class1funcCC2 = new FunctionCC("isBSTUtil", 4);
		// definierte Funktionen der Liste hinzuf�gen
		Proj3File10Class1functionCCs.add(proj3File10Class1funcCC1);
		Proj3File10Class1functionCCs.add(proj3File10Class1funcCC2);
		// setzen der funcCC Liste bei dem ClassMetrics Objekt
		Proj3File10Class1.setFunctionCCs(Proj3File10Class1functionCCs);

		ClassMetrics Proj3File10Class2 = new ClassMetrics(); //class Node in class ValidBSTOrNot
		Proj3File10Class2.setDit(0);
		Proj3File10Class2.setFunctionCCs(new ArrayList<>());


		// Projekt Trees Objekt:

		Summary projektTrees = new Summary();

		List<FileMetrics> fileMetrics3= new ArrayList<FileMetrics>();
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


		Map<ClassSpecifier, ClassMetrics> classMetrics3 = new HashMap<ClassSpecifier, ClassMetrics>();

		ClassSpecifier p3Cs1= new ClassSpecifier("AVLTree");
		ClassSpecifier p3Cs2= new ClassSpecifier("Node");
		ClassSpecifier p3Cs3= new ClassSpecifier("BinaryTree");
		ClassSpecifier p3Cs4= new ClassSpecifier("Node");
		ClassSpecifier p3Cs5= new ClassSpecifier("GenericTree");
		ClassSpecifier p3Cs6= new ClassSpecifier("Node");
		ClassSpecifier p3Cs7= new ClassSpecifier("LevelOrderTraversal");
		ClassSpecifier p3Cs8= new ClassSpecifier("Node");
		ClassSpecifier p3Cs9= new ClassSpecifier("LevelOrderTraversalQueue");
		ClassSpecifier p3Cs10= new ClassSpecifier("Node");
		ClassSpecifier p3Cs11= new ClassSpecifier("PrintTopViewofTree");
		ClassSpecifier p3Cs12= new ClassSpecifier("TreeNode");
		ClassSpecifier p3Cs13= new ClassSpecifier("QItem");
		ClassSpecifier p3Cs14= new ClassSpecifier("Tree");
		ClassSpecifier p3Cs15= new ClassSpecifier("RedBlackBST");
		ClassSpecifier p3Cs16= new ClassSpecifier("Node");
		ClassSpecifier p3Cs17= new ClassSpecifier("TreeTraversal");
		ClassSpecifier p3Cs18= new ClassSpecifier("Node");
		ClassSpecifier p3Cs19= new ClassSpecifier("TrieImp");
		ClassSpecifier p3Cs20= new ClassSpecifier("TrieNode");
		ClassSpecifier p3Cs21= new ClassSpecifier("ValidBSTOrNot");
		ClassSpecifier p3Cs22= new ClassSpecifier("Node");

		classMetrics3.put(p3Cs1, Proj3File1Class1);
		classMetrics3.put(p3Cs2, Proj3File1Class2);
		classMetrics3.put(p3Cs3, Proj3File2Class1);
		classMetrics3.put(p3Cs4, Proj3File2Class2);
		classMetrics3.put(p3Cs5, Proj3File3Class1);
		classMetrics3.put(p3Cs6, Proj3File3Class2);
		classMetrics3.put(p3Cs7, Proj3File4Class1);
		classMetrics3.put(p3Cs8, Proj3File4Class2);
		classMetrics3.put(p3Cs9, Proj3File5Class1);
		classMetrics3.put(p3Cs10, Proj3File5Class2);
		classMetrics3.put(p3Cs11, Proj3File6Class1);
		classMetrics3.put(p3Cs12, Proj3File6Class2);
		classMetrics3.put(p3Cs13, Proj3File6Class3);
		classMetrics3.put(p3Cs14, Proj3File6Class4);
		classMetrics3.put(p3Cs15, Proj3File7Class1);
		classMetrics3.put(p3Cs16, Proj3File7Class2);
		classMetrics3.put(p3Cs17, Proj3File8Class1);
		classMetrics3.put(p3Cs18, Proj3File8Class2);
		classMetrics3.put(p3Cs19, Proj3File9Class1);
		classMetrics3.put(p3Cs20, Proj3File9Class2);
		classMetrics3.put(p3Cs21, Proj3File10Class1);
		classMetrics3.put(p3Cs22, Proj3File10Class2);

		projektTrees.setClassMetrics(classMetrics3);

		return projektTrees;
	}
}
