package moe.shan.anonymous.model.media;

import moe.shan.anonymous.util.OptionalUtil;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Optional;

@Document(collection = "medias")
public record Media(
        @Id String id,
        String title,
        String desc,
        @Field("short_desc") String shortDesc,
        @Field("main_user") String mainUser,
        @Field("primary_img") String primaryImg,
        @Field("qrcode_img") String qrcodeImg,
        List<MediaLink> links,
        @Field("hot_index") Optional<Double> hotIndex
) {
    public Media {

        hotIndex = OptionalUtil.ofNullable(hotIndex, 0.0);

    }

    public record MediaLink(String type, String link, String name) {
    }


}
