package com.swe.janalyzer.cli;

import java.nio.file.Path;
import com.swe.janalyzer.storage.JSONConverter;

/**
 * Optionen werden verarbeitet
 */
public class OptionenVerarbeitung {

	public boolean verboseIsSet = false;
	/**
	 * Der Outputpfad wird verändert, nach dem was übergeben wird
	 * @param filePath ist der Outputpfad der in der Command Line mit gegeben wird.
	 */
	public void saveFileAtPath (Path filePath) {
		JSONConverter path = new JSONConverter();
		path.setOutputPath(filePath);
	}

	/**
	 * Verbose wird gesetzt, um es dann weiter zu verwerten für die Schritte ausgabe
	 * @return verboseIsSet
	 */
	public boolean verboseSet() {
		verboseIsSet = true;

		return verboseIsSet;
	}

//	public void manual() {
//		System.out.println(
//				// OPTION -o
//				"Option: -o <speicherpfad>, --output <speicherpfad>\r\n"
//						+ "Der Speicherort der, vom Programm erzeugten Analysedaten wird zu $speicherpfad"
//						+ "geändert. Falls diese Option nicht beim Aufruf des Programms genutzt wird, ist der\r\n"
//						+ "Speicherort:\r\n" + "$user.home/java_analyzer/$Projektname_X\r\n"
//						+ "$user.home ist hierbei das Benutzerverzeichnis des Benutzers, welcher das Programm "
//						+ "aufgerufen hat.\r\n"
//						+ "$Projektname_X ist hierbei der Name des Projektordners, gefolgt von einem Unterstrich"
//						+ "und einer natürlichen Zahl inklusive 0 (X ∈ 𝑁), um Duplikate bei mehrmaliger Analyse"
//						+ "des gleichen Projektes zu vermeiden.\r\n\n"
//						// OPTION -v
//						+ "Option: -v, --verbose\r\n"
//						+ "Das Programm gibt nach standard-out einzelne Schritte des Programmablaufes aus.\r\n"
//						+ "Die Ausgaben sind:\r\n" + "1. Processing file $file_path\r\n"
//						+ "Erklärung: Das Programm errechnet die Metriken für die Datei mit Pfad $file_path .\r\n"
//						+ "2. All files analyzed\r\n"
//						+ "Erklärung: Das Programm hat alle Programmdateien des Projektes analysiert.\r\n"
//						+ "3. Writing results to $output_file\r\n" + "40\r\n"
//						+ "Erklärung: Das Programm schreibt die Ergebnisse in die Datei unter dem Pfad\r\n"
//						+ "$output_file .");
//
//	}
}
