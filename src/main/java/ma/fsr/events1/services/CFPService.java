package ma.fsr.events1.services;

import ma.fsr.events1.entities.CFP;

import java.util.List;

public interface CFPService {

    CFP createCfp(CFP cfp);

    CFP getCfpById(long cfpId);

    List<CFP> getAllCfps();

    CFP updateCfp(long cfpId, CFP cfp);

    void deleteCfp(long cfpId);
}
