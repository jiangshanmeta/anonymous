package moe.shan.anonymous.model.userinvite;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import moe.shan.anonymous.converter.BoolNumberConverter;
import moe.shan.anonymous.model.user.User;
import moe.shan.anonymous.util.OptionalUtil;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.convert.PropertyValueConverter;
import org.springframework.data.convert.ValueConversionContext;
import org.springframework.data.convert.ValueConverter;
import org.springframework.data.mongodb.core.mapping.*;

import java.util.Arrays;
import java.util.Optional;

@Document(collection = "user_invites")
public record UserInvite(
        @Id String id,
        @Field("user_id")
        @JsonSerialize(using= ToStringSerializer.class)
        ObjectId userId,
        @Field("invite_code") String inviteCode,
        @ValueConverter(BoolNumberConverter.class)
        boolean status,
        @Field("target_id") @DocumentReference User targetId,
        @Field("reg_ts") Optional<Integer> regTS,
        @ValueConverter(UserInviteTypeConverter.class)  UserInviteType type
) {

    public UserInvite {
        regTS = OptionalUtil.ofNullable(regTS,0);

    }



    public enum UserInviteType {
        GENERAL_USER(0),
        EDITOR(1),
        COLUMN_EDITOR(2),
        EDITOR_CHIEF(3),;

        public final Number value;
        UserInviteType(int value){
            this.value = value;
        }
    }

    public static class UserInviteTypeConverter implements PropertyValueConverter<UserInviteType,Number, ValueConversionContext<?>> {

        @Override
        public UserInviteType read(Number value, ValueConversionContext<?> context) {
            return Arrays.stream(UserInviteType.values()).filter(item->item.value.intValue() == value.intValue()  ).findFirst().orElseGet(()->UserInviteType.GENERAL_USER)   ;
        }

        @Override
        public Number write(UserInviteType value, ValueConversionContext<?> context) {
            return value.value;
        }
    }




}
