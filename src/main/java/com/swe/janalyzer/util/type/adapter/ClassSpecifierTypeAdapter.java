package com.swe.janalyzer.util.type.adapter;

import com.google.gson.*;
import com.swe.janalyzer.util.ClassSpecifier;

import java.lang.reflect.Type;
import java.nio.file.Path;

public class ClassSpecifierTypeAdapter implements JsonDeserializer<ClassSpecifier>, JsonSerializer<ClassSpecifier> {
		@Override
		public ClassSpecifier deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws
				JsonParseException {
				return new ClassSpecifier(jsonElement.getAsString());
		}

		@Override
		public JsonElement serialize(ClassSpecifier specifier, Type type, JsonSerializationContext jsonSerializationContext) {
				return new JsonPrimitive(specifier.toString());
		}
}
