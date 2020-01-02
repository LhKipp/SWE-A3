package com.swe.janalyzer.storage;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.swe.janalyzer.data.metriken.*;
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
import java.util.List;
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

		public static void saveSummary(final Project project,
									   final Path filePath) throws IOException {
				Gson gson = new GsonBuilder()
						.setPrettyPrinting()
						.create();

				String json = gson.toJson(project);

				Files.write(filePath, json.getBytes());
		}

		public static Project loadSummary(Path filePath) throws IOException{
			Gson gson = new GsonBuilder()
					.create();

		    String data = String.join("\n",Files.readAllLines(filePath));

			Type listType = new TypeToken<Project>(){}.getType();

			return gson.<Project>fromJson(data,listType);
		}

		public static Options loadOptions() throws IOException {
				Gson gson = new GsonBuilder()
						.registerTypeHierarchyAdapter(Path.class, new PathTypeAdapter())
						.create();

				String data = (Files.lines(Constants.OPTION_PATH)).collect(Collectors.joining("\n"));
				return gson.fromJson(data, Options.class);
		}
}
