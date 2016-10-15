package com.ekc.c4q.jsonweather.internal;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

/**
 * INTERNAL USE ONLY. If you are a student, try not to touch this class kthx.
 * Validates in class exercise java objects against the respective json.
 */
public class JsonValidator {
  static final Gson GSON = new Gson();

  /**
   * Naive validator who assumes any field that is a default value is invalid. So please use json
   * examples that have non-default values in fields. The following default values will lead to
   * returning a false negative:<ul>
   * <li>int: 0
   * <li>boolean: false
   * <li>float: 0.0F
   * <li>double: 0.0D
   * <li>long: 0L
   * <li>Object: null
   * </ul>
   * Validator will handle array objects correctly and recursively validate inner objects.
   */
  public static <T> boolean validate(Class<?> clazz, String filepath) {
    System.out.println(String.format("Validating %s", clazz.getSimpleName()));
    try {
      JsonReader jsonReader = new JsonReader(new FileReader(filepath));
      final T pojo = GSON.fromJson(jsonReader, clazz);
      return validate(clazz, pojo);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      return failed();
    }
  }

  private static <T> boolean validate(Class<?> clazz, T pojo) {
    if (clazz.isArray()) {
      System.out.println("Array found, validating elements...");
      clazz = clazz.getComponentType();
      for (int i = 0; i < Array.getLength(pojo); i++) {
        System.out.println(String.format("Checking element %s...", i));
        if (!validate(clazz, Array.get(pojo, i))) {
          return false;
        }
      }
    } else {
      try {
        for (Field f : clazz.getDeclaredFields()) {
          f.setAccessible(true);
          Class type = f.getType();
          Object value = f.get(pojo);
          if (type == boolean.class && Boolean.FALSE.equals(value)) {
            return failed();
          } else if (type.isPrimitive() && ((Number) value).doubleValue() == 0) {
            return failed();
          } else if (!type.isPrimitive() && value == null) {
            return failed();
          }
        }
      } catch (IllegalAccessException e) {
        e.printStackTrace();
        return failed();
      }
    }
    return passed();
  }

  private static boolean passed() {
    System.out.println("Passed!");
    return true;
  }

  private static boolean failed() {
    System.out.println("Failed!");
    return false;
  }
}
