package com.oyerickshaw.rating.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.IntToLongFunction;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

import org.apache.commons.lang3.RandomStringUtils;

import com.oyerickshaw.rating.beans.Header;
import com.oyerickshaw.rating.beans.MsgInfo;
import com.oyerickshaw.rating.beans.Payload;
import com.oyerickshaw.rating.beans.Response;

public class Utility {
	private static AtomicLong idCounter = new AtomicLong();
	
	public static BinaryOperator<String> generateCacheKey = (verticalType, id) -> {
		return new StringBuilder(verticalType).append(".").append(id).toString();
	};
	
	public static Predicate<String> checkFileExtention = fileName -> fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0;
	
	public static UnaryOperator<String> getFileExtension = fileName -> {
		if(checkFileExtention.test(fileName))
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	};
	
	public static Supplier<String> generateOtp = () -> {
		Random random = new Random();
		return String.format("%06d", random.nextInt(1000000));
	};
	
	public static Supplier<String> generateSsoToken = () -> {
		UUID uuid = UUID.randomUUID();
		String uuidStr = uuid.toString();
		return uuidStr;
	};
	
	public static Function<String, String> getIds = s -> {
		StringBuilder sb = new StringBuilder();
		sb.append(s).append(String.valueOf(RandomStringUtils.randomAlphanumeric(3))).append(idCounter.getAndIncrement()).append(String.valueOf(RandomStringUtils.randomAlphanumeric(5)));
		return sb.toString();
	};
	
	public static Function<Object, Payload> getPayload = obj -> {
		Payload pay = new Payload();
		pay.setData(obj);
		return pay;
	};
	
	// check user phone no exists or not in table
	public static Predicate<String> isNumberPresent = pNo -> pNo.length() > 10;
	
	// Validate user otp
	public static BiFunction<String, String, Boolean> validateUserOtp = (otp, token) -> true;
	
	public static int indexOfLastSeparator(String filename){
		if (filename == null) {
            return -1;
        }
        int lastUnixPos = filename.lastIndexOf('/');
        int lastWindowsPos = filename.lastIndexOf('\\');
        return Math.max(lastUnixPos, lastWindowsPos);
	}
	
	public static int indexOfExtension(String filename){
		if (filename == null) {
            return -1;
        }
        int extensionPos = filename.lastIndexOf('.');
        int lastSeparator = indexOfLastSeparator(filename);
        return (lastSeparator > extensionPos ? -1 : extensionPos);
	}
	
	public static UnaryOperator<String> getFileExtention = fileName -> {
		 if (fileName == null) {
	            return null;
	        }
	        int index = indexOfExtension(fileName);
	        if (index == -1) {
	            return "";
	        } else {
	            return fileName.substring(index + 1);
	        }
	};
	
	public static BiFunction<String, String, Response> success = (token, msgDesc) -> {
		Response res = new Response();
		Header header = new Header();
		MsgInfo msg = new MsgInfo();
		header.setAppId("oyerickshaw");
		header.setTokenId(token);
		msg.setMsg("SUCCESS");
		msg.setMsgCode("200");
		msg.setMsgDescription(msgDesc);
		res.setHeader(header);
		res.setMsgInfo(msg);
		return res;
	};
	
	public static BiFunction<String, String, Response> newSuccess = (token, msgDesc) -> {
		Response res = new Response();
		Header header = new Header();
		MsgInfo msg = new MsgInfo();
		header.setAppId("oyerickshaw");
		header.setTokenId(token);
		msg.setMsg("SUCCESS");
		msg.setMsgCode("201");
		msg.setMsgDescription(msgDesc);
		res.setHeader(header);
		res.setMsgInfo(msg);
		return res;
	};
	
	public static BiFunction<String, String, Response> failure = (token, msgDesc) -> {
		Response res = new Response();
		Header header = new Header();
		MsgInfo msg = new MsgInfo();
		header.setAppId("oyerickshaw");
		header.setTokenId(token);
		msg.setMsg("AUTHORIZATION ERROR");
		msg.setMsgCode("403");
		msg.setMsgDescription(msgDesc);
		res.setHeader(header);
		res.setMsgInfo(msg);
		return res;
	};
	
	public static LongSupplier getCurrentDateInTimestampMilli = () -> {
		Instant instant = Instant.now();
		return instant.toEpochMilli();
	};
	
	public static IntToLongFunction getExpectedDelieveryDate = day -> {
		Instant instant = Instant.now();
		Instant ins = instant.plus(day , ChronoUnit.DAYS );
		return ins.toEpochMilli();
	};
	
	public static BiFunction<Long, String, String> timestampToDate = (timeStampMillis, format) -> {
		DateFormat simple = new SimpleDateFormat(format);
		Date result = new Date(timeStampMillis);
		return simple.format(result);
	};
	
}

