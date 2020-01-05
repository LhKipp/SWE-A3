package com.swe.janalyzer.storage;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import com.swe.janalyzer.data.metriken.*;
import com.swe.janalyzer.gui.data.NamedPath;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Speicherverwaltung.
 */
public class JSONConverter {


	public static void saveSummary(final Project project,
								   final Path filePath) throws IOException {
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();

		String json = gson.toJson(project);

<<<<<<< HEAD
				Files.write(filePath, json.getBytes());
<<<<<<< HEAD
			
=======
>>>>>>> e98706bfb048372ff740048464924674f2d9c6c4
		}
=======
		Files.write(filePath, json.getBytes());
	}

	public static Project loadSummary(Path filePath) throws IOException {
		Gson gson = new GsonBuilder()
				.create();

		String data = String.join("\n", Files.readAllLines(filePath));

		Type listType = new TypeToken<Project>() {
		}.getType();

		return gson.<Project>fromJson(data, listType);
	}

	public static <K, V> void saveMap(Map<K, V> map, Path path) throws IOException {
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.create();
		String json = gson.toJson(map);
		Files.write(path, json.getBytes());
	}

	public static <K, V> Map<K, V> loadMap(Path path) throws IOException {
		Gson gson = new GsonBuilder()
				.create();
		String data = String.join("\n", Files.readAllLines(path));
		Type listType = new TypeToken<HashMap<K, V>>() {
		}.getType();
		return gson.<HashMap<K, V>>fromJson(data, listType);
	}
>>>>>>> 6eb5374fcacfb50494b35d10e1507c16025ebeff

	public static void saveNamedPaths(List<NamedPath> namedPaths, Path path) throws IOException {
		Gson gson = new GsonBuilder()
				.setPrettyPrinting()
				.registerTypeAdapter(Path.class, new PathSerializer())
				.create();
		String json = gson.toJson(namedPaths);
		Files.write(path, json.getBytes());
	}

	public static List<NamedPath> loadNamedPaths(Path path) throws IOException {
		Gson gson = new GsonBuilder()
				.registerTypeAdapter(Path.class, new PathDeserializer())
				.create();
		String data = String.join("\n", Files.readAllLines(path));
		Type listType = new TypeToken<List<NamedPath>>() {
		}.getType();
		return gson.<List<NamedPath>>fromJson(data, listType);
	}


	public static class PathSerializer implements JsonSerializer<Path> {
		public JsonElement serialize(Path src, Type typeOfSrc, JsonSerializationContext context) {
			return new JsonPrimitive(src.toString());
		}
	}


	public static class PathDeserializer implements JsonDeserializer<Path> {
		public Path deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
				throws JsonParseException {
			return Paths.get(json.getAsJsonPrimitive().getAsString());
		}
	}
}
