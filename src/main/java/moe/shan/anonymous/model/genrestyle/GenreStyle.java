package moe.shan.anonymous.model.genrestyle;

import moe.shan.anonymous.converter.OptionalBoolNumberConverter;
import moe.shan.anonymous.util.OptionalUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Document(collection = "genre_style")
public record GenreStyle(
        @Id String id,
        String name,
        @Field("name_orig") String nameOrig,
        @Field("name_alt") String nameAlt,
        @Field("name_link") String nameLink,
        @Field("profile") String profile,
        @ValueConverter(GenreStyleType.GenreStyleTypeConverter.class) GenreStyleType type,
        @ValueConverter(GenreStyleQualityConverter.class) GenreStyleQuality quality,
        List<FieldStyle> parents,
        List<FieldStyle> origins,
        @Field("contribute_user") List<FieldUser> contributeUser,
        @Field("top_artists") List<TopArtist> topArtists,
        @Field("show_in_list") @ValueConverter(OptionalBoolNumberConverter.class) Optional<Boolean> showInList,
        @Field("show_in_front") @ValueConverter(OptionalBoolNumberConverter.class) Optional<Boolean> showInFront,
        @Field("counter_view") int counterView,
        @Field("counter_refrence") Optional<Integer> counterRefrence,
        @Field("counter_rank") Optional<Integer> counterRank,
        @Field("hot_index") int hotIndex,
        @Field("last_updated") Optional<Number> lastUpdated,
        @Field("primary_img") String primaryImg

) {

    public GenreStyle {
        counterRefrence = OptionalUtil.ofNullable(counterRefrence,0);
        counterRank = OptionalUtil.ofNullable(counterRank,0);
        lastUpdated = OptionalUtil.ofNullable(lastUpdated,0.0);
        quality = quality == null? GenreStyleQuality.NOT_MANUALLY_PROCESSED:quality;
        parents = parents == null? Collections.emptyList():parents;
        origins = origins == null? Collections.emptyList():origins;
        contributeUser = contributeUser == null ? Collections.emptyList():contributeUser;
        showInList = showInList == null ? Optional.of(false):showInList;
        showInFront = showInFront == null? Optional.of(false):showInFront;
        topArtists = topArtists == null? Collections.emptyList():topArtists;
    }

    public record FieldUser(@Id String _id){

    }

    public record FieldStyle(@Id String _id ){

    }

    public enum GenreStyleQuality {
        NOT_MANUALLY_PROCESSED(0),
        PRELIMINAEY_CORRECTION(1),
        LOCKED_IN_VOTING(2),
        LOCKED(3);

        private Number value;
        private GenreStyleQuality(Number value){
            this.value = value;
        }

    }

    public record TopArtist(
            @Id String _id,
            String name,
            @Field("primary_img") String primaryImg,
            @Field("begin_year") int beginYear,
            @Field("end_year") int endYear
    ){

    }







    public static class GenreStyleQualityConverter implements PropertyValueConverter<GenreStyleQuality,Number, ValueConversionContext<?>> {

        @Override
        public GenreStyleQuality read(Number value, ValueConversionContext<?> context) {

            return Arrays.stream(GenreStyleQuality.values()).filter(item->item.value.intValue() == value.intValue()  ).findFirst().orElseGet(()-> GenreStyleQuality.NOT_MANUALLY_PROCESSED)   ;
        }

        @Override
        public Number write(GenreStyleQuality value, ValueConversionContext<?> context) {
            return value.value;
        }
    }

}
