package lv.ez.util;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import lv.ez.util.dto.FormFirstStepDto;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class TestDataReader {

    private final String resourcePath;

    public TestDataReader(String resourcePath) {
        this.resourcePath = resourcePath;
    }

    public FormFirstStepDto findFirstStepForm(String tag) {
        List<FormFirstStepDto> users = getAllUser();
        return users.stream()
                .filter(userDto -> userDto.getTag()
                        .equals(tag))
                .findFirst()
                .get();
    }

    private List<FormFirstStepDto> getAllUser() {
        InputStream inputStream = getClass()
                .getClassLoader()
                .getResourceAsStream(resourcePath);
        JsonReader reader = new JsonReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        Type type = new TypeToken<ArrayList<FormFirstStepDto>>() {
        }.getType();
        Gson gson = new Gson();
        return gson.fromJson(reader, type);
    }
}
