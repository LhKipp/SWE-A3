package com.swe.janalyzer.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.swe.janalyzer.data.metriken.ClassMetrics;
import com.swe.janalyzer.data.metriken.FileMetrics;
import com.swe.janalyzer.data.metriken.Summary;
import com.swe.janalyzer.util.ClassSpecifier;
import com.swe.janalyzer.util.Constants;
import com.swe.janalyzer.util.Options;
import com.swe.janalyzer.util.type.adapter.ClassSpecifierTypeAdapter;
import com.swe.janalyzer.util.type.adapter.PathTypeAdapter;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Speicherverwaltung.
 * Stellt zwei statische Methoden zum Speichern und Laden der .json-Dati bereit
 */
public class JSONConverter {

		public static void saveOptions(Options options) throws IOException, NullPointerException {
				if (options == null) throw new NullPointerException();
				Gson gson = new GsonBuilder()
						.setPrettyPrinting()
						.registerTypeHierarchyAdapter(Path.class, new PathTypeAdapter())
						.create();
				String json = gson.toJson(options);

				Path filePath = Constants.OPTION_PATH;
				Files.createDirectories(filePath.getParent());
				Files.write(filePath, json.getBytes());
		}

		/**
		 * Speichert ein Objekt der Klasse Summary als .json ab.
		 * @param summary - Das zu speichernde Objekt.
		 * @param filePath - Der Pfad zur zu speichernden Datei.
		 * @throws IOException Wird ausgelöst, wenn das Programm nicht in die Datei schreiben kann.
		 */
		public static void saveSummary(Summary summary, Path filePath) throws IOException, NullPointerException {
				Gson gson = new GsonBuilder()
						.setPrettyPrinting()
						.registerTypeHierarchyAdapter(Path.class, new PathTypeAdapter())
						.registerTypeHierarchyAdapter(ClassSpecifier.class, new ClassSpecifierTypeAdapter())
						.create();

				String json = gson.toJson(summary.getFileMetrics());
				json += "\n" + Constants.SEPERATOR + "\n";
				json += gson.toJson(summary.getClassMetrics());

				//FÜR CLI
				try {
				Files.write(filePath, json.getBytes());
				}catch(IOException IOe){
					System.out.println("Could not write results to file with path: " + "$ergebnis_datei" + ". Stopping execution.");
				}catch(NullPointerException NPEe) {
					System.out.println("Could not write results to file with path: " + "$ergebnis_datei" + ". Stopping execution.");
				}
		}

		/**
		 * Lädt ein Objekt der Klasse Summary aus dem Speicher.
		 * @param filePath - Der Pfad zur zu lesenden Datei.
		 * @return Gibt die ausgelesene Datei als Summary zurück
		 * @throws IOException Wird ausgelöst, wenn das Programm die Datei nicht lesen konnte.
		 */
		public static Summary loadSummary(Path filePath) throws IOException, NullPointerException {
				Gson gson = new GsonBuilder()
						.registerTypeHierarchyAdapter(Path.class, new PathTypeAdapter())
						.registerTypeHierarchyAdapter(ClassSpecifier.class, new ClassSpecifierTypeAdapter())
						.create();

				Stream<String> lines = Files.lines(filePath);
				String data = lines.collect(Collectors.joining("\n"));
				String[] parts = data.split(Constants.SEPERATOR);

				Type listType = new TypeToken<ArrayList<FileMetrics>>(){}.getType();
				ArrayList<FileMetrics> list = gson.fromJson(parts[0],listType);

				Type mapType = new TypeToken<HashMap<ClassSpecifier, ClassMetrics>>(){}.getType();
				Map<ClassSpecifier, ClassMetrics> map = gson.fromJson(parts[1],mapType);
				Summary res = new Summary();
				res.setClassMetrics(map);
				res.setFileMetrics(list);
				return res;
		}

		public static Options loadOptions() throws IOException {
				Gson gson = new GsonBuilder()
						.registerTypeHierarchyAdapter(Path.class, new PathTypeAdapter())
						.create();

				String data = (Files.lines(Constants.OPTION_PATH)).collect(Collectors.joining("\n"));
				return gson.fromJson(data, Options.class);
		}
}
