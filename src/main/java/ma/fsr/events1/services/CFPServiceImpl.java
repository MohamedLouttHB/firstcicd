package ma.fsr.events1.services;

import lombok.AllArgsConstructor;
import ma.fsr.events1.entities.CFP;
import ma.fsr.events1.repositories.CFPRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor

public class CFPServiceImpl implements CFPService{

    private CFPRepository cfpRepository;

    @Override
    public CFP createCfp(CFP cfp) {
        return cfpRepository.save(cfp);
    }

    @Override
    public CFP getCfpById(long cfpId) {
        Optional<CFP> optionalCFP = cfpRepository.findById(cfpId);
        return optionalCFP.orElse(null);    }

    @Override
    public List<CFP> getAllCfps() {
        return cfpRepository.findAll();
    }

    @Override
    public CFP updateCfp(long cfpId, CFP cfp) {

        CFP existingCfp = this.getCfpById(cfpId);
        existingCfp.setDeadline(cfp.getDeadline());
        CFP updatedCfp = cfpRepository.save(existingCfp);
        return updatedCfp;    }

    @Override
    public void deleteCfp(long cfpId) {
        cfpRepository.deleteById(cfpId);
    }
}
