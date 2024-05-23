package moe.shan.anonymous.model.chronicle;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import moe.shan.anonymous.model.genrestyle.FieldGenreStyle;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "chronicles")
public record Chronicle(
        @Id String id,
        String title,
        String desc,
        @Field("primary_img") String primaryImg,
        @DocumentReference(lookup = "{ '_id' : ?#{_id} }") List<FieldGenreStyle> styles,
        @Field("user_created") @JsonSerialize(using= ToStringSerializer.class) ObjectId userCreated,
        @Field("ts_updated") int tsUpdated,
        @Field("ts_created") int tsCreated,
        @Field("begin_year") int beginYear,
        @Field("end_year") int endYear
        ) {

}
