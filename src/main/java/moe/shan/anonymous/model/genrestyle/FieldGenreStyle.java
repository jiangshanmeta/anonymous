package moe.shan.anonymous.model.genrestyle;

import org.springframework.data.annotation.Id;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "genre_style")
public record FieldGenreStyle(
        @Id String id,
        String name,
        @Field("name_link") String nameLink,
        @Field("name_orig") String nameOrig,
        @ValueConverter(GenreStyleType.GenreStyleTypeConverter.class) GenreStyleType type
) {

}
