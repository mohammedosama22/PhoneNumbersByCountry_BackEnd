package com.jumia.app.serviceImpl;

import org.springframework.stereotype.Service;

import com.jumia.app.service.RegexService;
import com.jumia.app.util.CommonConstants;

@Service
public class RegexServiceImpl implements RegexService {

	@Override
	public String getRegex(String country) {
		String regex = "";
		switch (country) {

		case "Cameroon":
			regex = CommonConstants.CAMEROON_REGEX;
			break;

		case "Ethiopia":
			regex = CommonConstants.ETHIOPIA_REGEX;
			;
			break;

		case "Morocco":
			regex = CommonConstants.MOROCCO_REGEX;
			;
			break;

		case "Mozambique":
			regex = CommonConstants.MOZAMBIQUE_REGEX;
			;
			break;

		case "Ugandan":
			regex = CommonConstants.UGANDAN_REGEX;
			;
			break;

		default:
			break;
		}
		return regex;
	}

}
