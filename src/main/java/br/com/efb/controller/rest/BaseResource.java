package br.com.efb.controller.rest;

//import br.com.pfm.digitalsignatures.cert.ext.icpbrasil.CertificadoICPBrasil;
//import br.com.pfm.enums.CMSWorkflow;
//import br.com.pfm.integration.rest.api.dto.*;
//import br.com.pfm.integration.rest.api.errorhandling.AppException;
//import br.com.pfm.integration.rest.api.security.TokenUtil;
//import br.com.pfm.model.bean.search.ParticipantSearchBean;
//import br.com.pfm.model.service.*;
//import br.com.pfm.model.valueobjects.*;
//import br.com.pfm.utils.DateTimeUtil;
//import br.com.pfm.view.util.CMSConfig;
//import org.apache.commons.codec.binary.Base64;
import br.com.efb.controller.Service.UsuarioService;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.*;
import java.math.*;
import java.util.*;

/**
 * Created by mohashi on 06/04/16.
 */
public class BaseResource {

    private WebApplicationContext webApplicationContext;

    protected Logger logger = Logger.getLogger(this.getClass());

    @Context
    protected HttpServletRequest request;

     protected UsuarioService usuarioService;

//    protected Integer cmsDeferralDays = 0;

    protected void init() {
        usuarioService = getBean("usuarioService",UsuarioService.class);
//        cmsConfig = getBean("cmsConfig", CMSConfig.class);
//        cmsService = getBean("cmsService", ICMSService.class);
//        participantService = getBean("participantService", IParticipantService.class);
//        iSecurityAAService = getBean("securityService", ISecurityAAService.class);
//        basicRecordService = getBean("basicRecordService", IBasicRecordService.class);
//        coreService = getBean("coreService", ICoreService.class);

//        String deffDays = getSystemParameterValue("DEFERRAL_DAYS");
//
//        if (deffDays != null) {
//            this.cmsDeferralDays = new Integer(deffDays);
//        }

    }

    protected String getSystemParameterValue(String paramName) {

//        SystemParameterVO element = coreService.getSystemParameterByName( paramName );
//
//        if (element != null && element.getParm_val() != null) {
//            return element.getParm_val();
//        }

        return null;

    }

    @Context
    protected void setWebApplicationContext(ServletContext servletContext) {
        webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        init();
    }

    protected WebApplicationContext getWebApplicationContext() {
        return webApplicationContext;
    }

    @SuppressWarnings("unchecked")
    protected <T> T getBean(String beanName, Class<T> beanType) {
        return (T) getWebApplicationContext().getBean(beanName, beanType);
    }

//    public String[] nullSafeToOperationStatus(Status... operationStatus) {
//        List<String> operationStatusList = new LinkedList<String>();
//        for (Status item : operationStatus) {
//            if (Status.PENDING_VALIDATION.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_PENDING_VALIDATION);
//            } else if (Status.PENDING_SIGNATURE.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_PENDING_SIGNATURES);
//            } else if (Status.CLOSED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CLSD_OK);
//            } else if (Status.CLOSED_MANUALLY.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CLSD_OK_MANUAL);
//            } else if (Status.CANCELED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CANCELED);
//            } else if (Status.DISAGREED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_DISAGREEMENT);
//            } else if (Status.ERROR.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_ERROR);
//            } else if (Status.PENDING_APPROVAL.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CNTPRTY_PENDING_APPROVAL);
//            } else if (Status.MIGRATED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_MIGRATED_FROM_PREVIOUS_SYSTEMS);
//            } else if (Status.BLOCKED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_BLOCKED);
//            } else if (Status.NOT_APPROVED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CNTPRTY_NOT_APPROVED);
//            }
//        }
//        return operationStatusList.toArray(new String[0]);
//    }
//
//    public <T> T nullSafeTransform(Class<T> type, Object value) {
//        if (value != null) {
//            if (String.class.equals(type)) {
//                return (T) String.valueOf(value);
//            } else if (BigDecimal.class.equals(type) && (value instanceof Long)) {
//                return (T) BigDecimal.valueOf((Long) value);
//            } else if (BigDecimal.class.equals(type) && (value instanceof String)) {
//                return (T) new BigDecimal((String) value);
//            } else if (BigDecimal.class.equals(type) && (value instanceof Double)) {
//                return (T) BigDecimal.valueOf((Double) value);
//            } else if (Double.class.equals(type) && (value instanceof Double)) {
//                return (T) Double.valueOf((Double) value);
//            } else if (Double.class.equals(type) && (value instanceof BigDecimal)) {
//                return (T) Double.valueOf(((BigDecimal) value).doubleValue());
//            } else if (Integer.class.equals(type) && (value instanceof BigInteger)) {
//                return (T) Integer.valueOf(((BigInteger) value).intValue());
//            } else if (Integer.class.equals(type) && (value instanceof String)) {
//                return (T) Integer.valueOf((String) value);
//            } else if (Integer[].class.equals(type) && (value instanceof BigInteger[])) {
//                List<Integer> integerList = new LinkedList<Integer>();
//                for (BigInteger bigInteger : (BigInteger[]) value) {
//                    integerList.add(bigInteger.intValue());
//                }
//                return (T) integerList.toArray(new Integer[0]);
//            }
//            throw new IllegalArgumentException("NullSafe type transformation not supported!");
//        }
//        return null;
//    }
//
//    public CMSOperationTypeVO[] getCmsOperationTypeVO(String... operationTypes) throws AppException {
//        List<CMSOperationTypeVO> cmsOperationTypeList = new LinkedList<CMSOperationTypeVO>();
//        for (String operationType : operationTypes) {
//            CMSOperationTypeVO cmsOperationTypeVO = cmsService.getCmsOperationTypeByExtCode(operationType);
//
//            if (cmsOperationTypeVO == null) {
//                AppException appException = new AppException();
//                appException.setCode(5001);
//                appException.setStatus(Response.Status.BAD_REQUEST.getStatusCode());
//                appException.setDeveloperMessage("The operation type with external code " + operationType + " was not found.");
//                throw appException;
//            }
//            cmsOperationTypeList.add(cmsOperationTypeVO);
//        }
//        return cmsOperationTypeList.toArray(new CMSOperationTypeVO[0]);
//    }
//
//    public OperationDTO toOperationDTO(CMSOperationVO cmsOperationVO) throws Exception {
//
//        if (cmsOperationVO == null) {
//            return null;
//        }
//
//        OperationDTO operationDTO = new OperationDTO();
//
//        operationDTO.setAmount(cmsOperationVO.getOpertn_val());
//        operationDTO.setAmountForeign(cmsOperationVO.getOpertn_frgn_val());
//        operationDTO.setBank(toEntityDTO(cmsOperationVO.getEntity_bank()));
//        operationDTO.setBankStatus(toStatusValue(cmsOperationVO.getOpertn_cntprty_bank_stus()));
//        operationDTO.setBroker(toEntityDTO(cmsOperationVO.getEntity_broker()));
//        operationDTO.setBrokerStatus(toStatusValue(cmsOperationVO.getOpertn_cntprty_admintr_stus()));
//        operationDTO.setClient(toEntityDTO(cmsOperationVO.getEntity()));
//        operationDTO.setClientStatus(toStatusValue(cmsOperationVO.getOpertn_cntprty_ent_stus()));
//        operationDTO.setContractNumber(cmsOperationVO.getCntrct_nr());
//        operationDTO.setCreationDate(cmsOperationVO.getCreatn_dt());
//        operationDTO.setDeferralDate(cmsOperationVO.getXpirtn_dt());
//        operationDTO.setEffectiveDate(cmsOperationVO.getOpertn_dt());
//        operationDTO.setEventType(cmsOperationVO.getEvnt_typ());
//        operationDTO.setCurrency(toCurrencyDTO(cmsOperationVO.getCurrency()));
//        operationDTO.setExpirationDate(cmsOperationVO.getXpirtn_dt());
//        operationDTO.setExpirationMaturityDate(cmsOperationVO.getMtrty_dt());
//        operationDTO.setFlag_icst(("Y".equals(cmsOperationVO.getFlag_icst()) ? Boolean.TRUE :
//                Boolean.FALSE));
//        operationDTO.setFx_rate(cmsOperationVO.getFx_rate());
//        operationDTO.setId_opertn(cmsOperationVO.getId_opertn());
//        operationDTO.setHas_cntprty_bank_bool(cmsOperationVO.isHas_cntprty_bank_bool());
//        operationDTO.setOperationType(toOperationTypeDTO(cmsOperationVO.getOperationType()));
//        operationDTO.setOpertn_buyr_oseas(cmsOperationVO.getOpertn_buyr_oseas());
//        operationDTO.setOpertn_has_cntprty_admintr(cmsOperationVO.isHas_cntprty_admintr_bool());
//        operationDTO.setOpertn_has_cntprty_bank(cmsOperationVO.isHas_cntprty_bank_bool());
//        operationDTO.setOpertn_has_cntprty_ent(cmsOperationVO.isHas_cntprty_ent_bool());
//        operationDTO.setOpertn_has_vldt(cmsOperationVO.isHas_vldt_bool());
//        operationDTO.setOpertn_nat_cod(cmsOperationVO.getOpertn_nat_cod());
//        operationDTO.setOpertn_nat_desc(cmsOperationVO.getOpertn_nat_desc());
//        operationDTO.setPrpsl_nr(cmsOperationVO.getPrpsl_nr());
//        operationDTO.setReset_rsn(cmsOperationVO.getReset_rsn());
//        operationDTO.setSrc(cmsOperationVO.getSrc());
//        operationDTO.setStatus(toStatusValue(cmsOperationVO.getOpertn_stus()));
//        operationDTO.setTransactionType(cmsOperationVO.getTran_typ());
//        operationDTO.setVerificationCode(cmsOperationVO.getVrfctn_code());
//
//        return operationDTO;
//
//    }
//
//    public OperationDTO toOperationDTO(CompositeCMSOperationVO cmsOperationVO) throws Exception {
//
//        if (cmsOperationVO == null) {
//            return null;
//        }
//
//        OperationDTO operationDTO = new OperationDTO();
//
//        operationDTO.setAmount(cmsOperationVO.getCmsOperationVO().getOpertn_val());
//        operationDTO.setAmountForeign(cmsOperationVO.getCmsOperationVO().getOpertn_frgn_val());
//        operationDTO.setBank(toEntityDTO(cmsOperationVO.getCmsOperationVO().getEntity_bank()));
//        operationDTO.setBankStatus(toStatusValue(cmsOperationVO.getCmsOperationVO().getOpertn_cntprty_bank_stus()));
//        operationDTO.setBroker(toEntityDTO(cmsOperationVO.getCmsOperationVO().getEntity_broker()));
//        operationDTO.setBrokerStatus(toStatusValue(cmsOperationVO.getCmsOperationVO().getOpertn_cntprty_admintr_stus()));
//        operationDTO.setClient(toEntityDTO(cmsOperationVO.getCmsOperationVO().getEntity()));
//        operationDTO.setClientStatus(toStatusValue(cmsOperationVO.getCmsOperationVO().getOpertn_cntprty_ent_stus()));
//        operationDTO.setContractNumber(cmsOperationVO.getCmsOperationVO().getCntrct_nr());
//        operationDTO.setCreationDate(cmsOperationVO.getCmsOperationVO().getCreatn_dt());
//
//        if (cmsDeferralDays > 0 && cmsOperationVO.getCmsOperationVO().getXpirtn_dt() != null) {
//            operationDTO.setDeferralDate(DateTimeUtil.getDeferralDate(cmsOperationVO.getCmsOperationVO().getXpirtn_dt(), cmsDeferralDays));
//        } else {
//            operationDTO.setDeferralDate(cmsOperationVO.getCmsOperationVO().getXpirtn_dt());
//        }
//
//        operationDTO.setEffectiveDate(cmsOperationVO.getCmsOperationVO().getOpertn_dt());
//        operationDTO.setEventType(cmsOperationVO.getCmsOperationVO().getEvnt_typ());
//        operationDTO.setCurrency(toCurrencyDTO(cmsOperationVO.getCmsOperationVO().getCurrency()));
//        operationDTO.setExpirationDate(cmsOperationVO.getCmsOperationVO().getXpirtn_dt());
//        operationDTO.setExpirationMaturityDate(cmsOperationVO.getCmsOperationVO().getMtrty_dt());
//        operationDTO.setFlag_icst(("Y".equals(cmsOperationVO.getCmsOperationVO().getFlag_icst()) ? Boolean.TRUE :
//                Boolean.FALSE));
//        operationDTO.setFx_rate(cmsOperationVO.getCmsOperationVO().getFx_rate());
//        operationDTO.setId_opertn(cmsOperationVO.getCmsOperationVO().getId_opertn());
//        operationDTO.setHas_cntprty_bank_bool(cmsOperationVO.getCmsOperationVO().isHas_cntprty_bank_bool());
//        operationDTO.setOperationType(toOperationTypeDTO(cmsOperationVO.getCmsOperationVO().getOperationType()));
//        operationDTO.setOpertn_buyr_oseas(cmsOperationVO.getCmsOperationVO().getOpertn_buyr_oseas());
//        operationDTO.setOpertn_has_cntprty_admintr(cmsOperationVO.getCmsOperationVO().isHas_cntprty_admintr_bool());
//        operationDTO.setOpertn_has_cntprty_bank(cmsOperationVO.getCmsOperationVO().isHas_cntprty_bank_bool());
//        operationDTO.setOpertn_has_cntprty_ent(cmsOperationVO.getCmsOperationVO().isHas_cntprty_ent_bool());
//        operationDTO.setOpertn_has_vldt(cmsOperationVO.getCmsOperationVO().isHas_vldt_bool());
//        operationDTO.setOpertn_nat_cod(cmsOperationVO.getCmsOperationVO().getOpertn_nat_cod());
//        operationDTO.setOpertn_nat_desc(cmsOperationVO.getCmsOperationVO().getOpertn_nat_desc());
//        operationDTO.setPrpsl_nr(cmsOperationVO.getCmsOperationVO().getPrpsl_nr());
//        operationDTO.setReset_rsn(cmsOperationVO.getCmsOperationVO().getReset_rsn());
//        operationDTO.setSrc(cmsOperationVO.getCmsOperationVO().getSrc());
//        operationDTO.setStatus(toStatusValue(cmsOperationVO.getCmsOperationVO().getOpertn_stus()));
//        operationDTO.setTransactionType(cmsOperationVO.getCmsOperationVO().getTran_typ());
//        operationDTO.setVerificationCode(cmsOperationVO.getCmsOperationVO().getVrfctn_code());
//        operationDTO.setCoSign(cmsOperationVO.getCoSign() == null ? false : cmsOperationVO.getCoSign());
//        operationDTO.setLastUpdateDate(cmsOperationVO.getCmsOperationVO().getLast_updt_dt());
//        operationDTO.setSgntr_seq_ent(cmsOperationVO.getCmsOperationVO().getSgntr_seq_ent());
//        operationDTO.setSgntr_seq_admintr(cmsOperationVO.getCmsOperationVO().getSgntr_seq_admintr());
//        operationDTO.setSgntr_seq_bank(cmsOperationVO.getCmsOperationVO().getSgntr_seq_bank());
//
//        if (cmsOperationVO.getCmsCounterPartVOs() != null && cmsOperationVO.getCmsCounterPartVOs().size() > 0) {
//            operationDTO.setCounterParts(new ArrayList<OperationCounterPartDTO>());
//            for (CMSCounterPartVO cmsCounterPartVO : cmsOperationVO.getCmsCounterPartVOs()) {
//                operationDTO.getCounterParts().add(toOperationCounterPartDTO(cmsCounterPartVO));
//            }
//        }
//
//        return operationDTO;
//
//    }
//
//    public OperationCounterPartDTO toOperationCounterPartDTO(CMSCounterPartVO cmsCounterPartVO) {
//
//        if (cmsCounterPartVO == null) {
//            return null;
//        }
//
//        OperationCounterPartDTO operationCounterPartDTO = new OperationCounterPartDTO();
//
//        operationCounterPartDTO.setType(cmsCounterPartVO.getType());
//        operationCounterPartDTO.setEntity(toEntityDTO(cmsCounterPartVO.getEntity()));
//        operationCounterPartDTO.setStatus(toStatusValue(cmsCounterPartVO.getStatus()));
//        operationCounterPartDTO.setStep(cmsCounterPartVO.getStep());
//
//        if (cmsCounterPartVO.getRecords() != null && cmsCounterPartVO.getRecords().size() > 0) {
//            operationCounterPartDTO.setRecords(new ArrayList<OperationCounterPartRecordsDTO>());
//            for (CMSOperationWkflCntrlVO cmsOperationWkflCntrlVO : cmsCounterPartVO.getRecords()) {
//                operationCounterPartDTO.getRecords().add(toOperationCounterPartRecordsDTO(cmsOperationWkflCntrlVO));
//            }
//        }
//
//        if (cmsCounterPartVO.getParticipants() != null && cmsCounterPartVO.getParticipants().size() > 0) {
//            operationCounterPartDTO.setParticipants(new ArrayList<OperationCounterPartParticipantDTO>());
//            for (CMSCounterPartParticipantVO cmsCounterPartParticipantVO : cmsCounterPartVO.getParticipants()) {
//                OperationCounterPartParticipantDTO operationCounterPartParticipantDTO = toOperationCounterPartPaticipantDTO(cmsCounterPartParticipantVO);
//                operationCounterPartParticipantDTO.setSigned(checkParticipantSignatureStatus(cmsCounterPartParticipantVO, cmsCounterPartVO.getRecords()));
//                operationCounterPartDTO.getParticipants().add(operationCounterPartParticipantDTO);
//            }
//        }
//
//        return operationCounterPartDTO;
//
//    }
//
//    public boolean checkParticipantSignatureStatus(CMSCounterPartParticipantVO cmsCounterPartParticipantVO, Collection<CMSOperationWkflCntrlVO> records) {
//
//        boolean hasSigned = false;
//
//        if (records != null && records.size() > 0) {
//            for (CMSOperationWkflCntrlVO wfwVO : records) {
//                if (wfwVO.getSignature() != null && wfwVO.getSignature().getParticipantVO().getId_prtcpnt().intValue() ==
//                        cmsCounterPartParticipantVO.getSignature().getParticipantVO().getId_prtcpnt().intValue()) {
//                    hasSigned = true;
//                }
//            }
//        }
//
//        return hasSigned;
//
//    }
//
//    public OperationCounterPartRecordsDTO toOperationCounterPartRecordsDTO(CMSOperationWkflCntrlVO cmsOperationWkflCntrlVO) {
//
//        if (cmsOperationWkflCntrlVO == null) {
//            return null;
//        }
//
//        OperationCounterPartRecordsDTO operationCounterPartRecordsDTO = new OperationCounterPartRecordsDTO();
//
//        operationCounterPartRecordsDTO.setEvnt_cntprty(cmsOperationWkflCntrlVO.getEvnt_cntprty());
//        operationCounterPartRecordsDTO.setEvnt_dt(cmsOperationWkflCntrlVO.getEvnt_dt());
//        operationCounterPartRecordsDTO.setEvnt_obs(cmsOperationWkflCntrlVO.getEvnt_obs());
//        operationCounterPartRecordsDTO.setEvnt_typ(cmsOperationWkflCntrlVO.getEvnt_typ());
//        if (cmsOperationWkflCntrlVO.getUser() != null) {
//            operationCounterPartRecordsDTO.setUser(cmsOperationWkflCntrlVO.getUser().getName());
//        }
//        if (cmsOperationWkflCntrlVO.getEntityValidator() != null) {
//            operationCounterPartRecordsDTO.setUser(cmsOperationWkflCntrlVO.getEntityValidator().getVldtr_nm());
//        }
//        if (cmsOperationWkflCntrlVO.getSignature() != null) {
//            operationCounterPartRecordsDTO.setUser(cmsOperationWkflCntrlVO.getSignature().getParticipantVO().getPrtcpnt_nm());
//        }
//
//        CertificadoICPBrasil certificadoICPBrasil = cmsOperationWkflCntrlVO.getCertificateICPBrasil();
//
//        operationCounterPartRecordsDTO.setCertificate(toCertificateDTO(certificadoICPBrasil));
//
//        return operationCounterPartRecordsDTO;
//
//    }
//
//    public CertificateDTO toCertificateDTO(CertificadoICPBrasil certificadoICPBrasil) {
//
//        if (certificadoICPBrasil == null) {
//            return null;
//        }
//
//        CertificateDTO certificateDTO = new CertificateDTO();
//
//        certificateDTO.setAlgorithm(certificadoICPBrasil.getSigAlgName());
//        certificateDTO.setCpf(certificadoICPBrasil.getDadoPessoa().getCpf());
//        certificateDTO.setEmail(certificadoICPBrasil.getEmail());
//        certificateDTO.setExpired(false);
//        certificateDTO.setIssuedTo(certificadoICPBrasil.getSubjectDN().getName());
//        certificateDTO.setIssuer(certificadoICPBrasil.getIssuerX500Principal().getName());
//        certificateDTO.setRevoked(false);
//        certificateDTO.setRg(certificadoICPBrasil.getDadoPessoa().getRg());
//        certificateDTO.setType(certificadoICPBrasil.getTipoFormatoAsString());
//        certificateDTO.setValid(true);
//        certificateDTO.setValidFrom(certificadoICPBrasil.getNotBefore());
//        certificateDTO.setValidTo(certificadoICPBrasil.getNotAfter());
//        certificateDTO.setVersion(new Integer(certificadoICPBrasil.getVersion()).toString());
//        certificateDTO.setSerial(certificadoICPBrasil.getSerialNumber().toString());
//
//        return certificateDTO;
//
//    }
//
//    public OperationCounterPartParticipantDTO toOperationCounterPartPaticipantDTO(CMSCounterPartParticipantVO cmsCounterPartParticipantVO) {
//
//        if (cmsCounterPartParticipantVO == null) {
//            return null;
//        }
//
//        OperationCounterPartParticipantDTO operationCounterPartParticipantDTO = new OperationCounterPartParticipantDTO();
//
//        operationCounterPartParticipantDTO.setName(cmsCounterPartParticipantVO.getSignature().getParticipantVO().getPrtcpnt_nm());
//        operationCounterPartParticipantDTO.setCpf(cmsCounterPartParticipantVO.getSignature().getParticipantVO().getCpf_nr());
//        operationCounterPartParticipantDTO.setId(cmsCounterPartParticipantVO.getSignature().getParticipantVO().getId_prtcpnt().toString());
//        //TODO Validar nos registros de assinaturas se este participante, para esta contraparte ja assinou
//        operationCounterPartParticipantDTO.setSigned(false);
//
//        return operationCounterPartParticipantDTO;
//
//    }
//
//    public EntityDTO toEntityDTO(EntityVO entityVO) {
//
//        if (entityVO == null) {
//            return null;
//        }
//
//        EntityDTO dto = new EntityDTO();
//
//        dto.setIdEnt(entityVO.getId_ent().toString());
//        dto.setCnpj_cpf(entityVO.getCpf_cnpj_nr());
//        dto.setExtCode(entityVO.getId_ente() == null ? null : entityVO.getId_ente().toString());
//        dto.setPersonType(entityVO.getPrsn_typ());
//        dto.setSocialName(entityVO.getEnt_nm());
//
//        return dto;
//
//    }
//
//    public CurrencyDTO toCurrencyDTO(CurrencyVO currencyVO) {
//
//        if (currencyVO == null) {
//            return null;
//        }
//
//        CurrencyDTO dto = new CurrencyDTO();
//
//        dto.setExtCode(currencyVO.getId_crncy_ext());
//        dto.setAbbrvName(currencyVO.getCrncy_abbrv_nm());
//        dto.setDescription(currencyVO.getCrncy_nm());
//
//        return dto;
//
//    }
//
//    public OperationTypeDTO toOperationTypeDTO(CMSOperationTypeVO cmsOperationTypeVO) {
//
//        if (cmsOperationTypeVO == null) {
//            return null;
//        }
//
//        OperationTypeDTO dto = new OperationTypeDTO();
//
//        dto.setIdOperationType(cmsOperationTypeVO.getId_opertn_typ().toString());
//        dto.setExtCode(cmsOperationTypeVO.getExt_code());
//        dto.setDescription(cmsOperationTypeVO.getOpertn_typ_nm());
//
//        return dto;
//
//    }
//
//    public FileDTO toFileDTO(CMSOperationFileVO cmsOperationFileVO) throws Exception {
//
//        if (cmsOperationFileVO == null) {
//            return null;
//        }
//
//        FileDTO dto = new FileDTO();
//
//        dto.setId(cmsOperationFileVO.getId_opertn_file().toString());
//        dto.setName(cmsOperationFileVO.getDcmnt_nm());
//        dto.setType(cmsOperationFileVO.getDcmnt_ctnt_typ());
//
//        byte[] originalContent = new byte[(int)cmsOperationFileVO.getDcmnt().length()];
//        cmsOperationFileVO.getDcmnt().getBinaryStream().read(originalContent);
//        dto.setBase64Encoded(Base64.encodeBase64String(originalContent));
//
//        return dto;
//
//    }
//
//    public String toStatusValue(String value) {
//
//        if (value == null) {
//            return null;
//        }
//
//        if (CMSWorkflow.WKFW_CNTPRTY_NOK.equalsIgnoreCase(value)) {
//            return Status.PENDING_SIGNATURE;
//        } else if (CMSWorkflow.WKFW_CNTPRTY_NOT_APPROVED.equalsIgnoreCase(value)) {
//            return Status.NOT_APPROVED;
//        } else if (CMSWorkflow.WKFW_CNTPRTY_OK.equalsIgnoreCase(value)) {
//            return Status.CLOSED;
//        } else if (CMSWorkflow.WKFW_BLOCKED.equalsIgnoreCase(value)) {
//            return Status.BLOCKED;
//        } else if (CMSWorkflow.WKFW_CANCELED.equalsIgnoreCase(value)) {
//            return Status.CANCELED;
//        } else if (CMSWorkflow.WKFW_CLSD_OK.equalsIgnoreCase(value)) {
//            return Status.CLOSED;
//        } else if (CMSWorkflow.WKFW_CLSD_OK_MANUAL.equalsIgnoreCase(value)) {
//            return Status.CLOSED_MANUALLY;
//        } else if (CMSWorkflow.WKFW_CNTPRTY_PENDING_APPROVAL.equalsIgnoreCase(value)) {
//            return Status.PENDING_APPROVAL;
//        } else if (CMSWorkflow.WKFW_DISAGREEMENT.equalsIgnoreCase(value)) {
//            return Status.DISAGREED;
//        } else if (CMSWorkflow.WKFW_ERROR.equalsIgnoreCase(value)) {
//            return Status.ERROR;
//        } else if (CMSWorkflow.WKFW_MIGRATED_FROM_PREVIOUS_SYSTEMS.equalsIgnoreCase(value)) {
//            return Status.MIGRATED;
//        } else if (CMSWorkflow.WKFW_NOT_DIGITAL_OPERTN.equalsIgnoreCase(value)) {
//            return Status.MIGRATED;
//        } else if (CMSWorkflow.WKFW_NOT_VALIDATED.equalsIgnoreCase(value)) {
//            return Status.NOT_VALIDATED;
//        } else if (CMSWorkflow.WKFW_PENDING_SIGNATURES.equalsIgnoreCase(value)) {
//            return Status.PENDING_SIGNATURE;
//        } else if (CMSWorkflow.WKFW_PENDING_VALIDATION.equalsIgnoreCase(value)) {
//            return Status.PENDING_VALIDATION;
//        }
//
//        return null;
//
//    }
//
//    public List<OperationDTO> toOperationDTOList(Collection<CompositeCMSOperationVO> cmsOperationVOS) throws Exception {
//
//        List<OperationDTO> operationDTOS = new ArrayList<OperationDTO>();
//
//        if (cmsOperationVOS != null && cmsOperationVOS.size() > 0) {
//
//            for (CompositeCMSOperationVO cmsOperationVO : cmsOperationVOS) {
//
//                operationDTOS.add(toOperationDTO(cmsOperationVO));
//
//            }
//
//        }
//
//        return operationDTOS;
//
//    }
//
//    public List<OperationTypeDTO> toOperationTypeDTOList(Collection<CMSOperationTypeVO> cmsOperationTypeVOS) throws Exception {
//
//        List<OperationTypeDTO> operationDTOS = new ArrayList<OperationTypeDTO>();
//
//        if (cmsOperationTypeVOS != null && cmsOperationTypeVOS.size() > 0) {
//
//            for (CMSOperationTypeVO cmsOperationVO : cmsOperationTypeVOS) {
//
//                operationDTOS.add(toOperationTypeDTO(cmsOperationVO));
//
//            }
//
//        }
//
//        return operationDTOS;
//
//    }
//
//    public String[] nullSafeToOperationStatus(String[] operationStatus) {
//        List<String> operationStatusList = new LinkedList<String>();
//        for (String item : operationStatus) {
//            if (Status.PENDING_VALIDATION.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_PENDING_VALIDATION);
//            } else if (Status.PENDING_SIGNATURE.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_PENDING_SIGNATURES);
//            } else if (Status.CLOSED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CLSD_OK);
//            } else if (Status.CLOSED_MANUALLY.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CLSD_OK_MANUAL);
//            } else if (Status.CANCELED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CANCELED);
//            } else if (Status.DISAGREED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_DISAGREEMENT);
//            } else if (Status.ERROR.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_ERROR);
//            } else if (Status.PENDING_APPROVAL.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CNTPRTY_PENDING_APPROVAL);
//            } else if (Status.MIGRATED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_MIGRATED_FROM_PREVIOUS_SYSTEMS);
//            } else if (Status.BLOCKED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_BLOCKED);
//            } else if (Status.NOT_APPROVED.equals(item)) {
//                operationStatusList.add(CMSWorkflow.WKFW_CNTPRTY_NOT_APPROVED);
//            }
//        }
//        return operationStatusList.toArray(new String[0]);
//    }
//
//    public ParticipantVO findParticipantByCpf(String cpf) {
//
//        if (cpf == null) {
//            return null;
//        }
//
//        ParticipantSearchBean participantSearchBean = new ParticipantSearchBean();
//        participantSearchBean.setCpf_nr(cpf);
//        participantSearchBean.setMaxResults(1);
//
//        Iterator<ParticipantVO> participantVOIterator = participantService.getParticipants(participantSearchBean).iterator();
//
//        if (participantVOIterator.hasNext()) {
//            return participantVOIterator.next();
//        }
//
//        return null;
//
//    }
//
//    protected UserDTO getLoggedUserDTO() throws Exception {
//
//        String token = request.getHeader(TokenUtil.JWT_TOKEN_ATTR);
//
//        if (token != null) {
//
//            return TokenUtil.getUserFromToken(token);
//
//        }
//
//        return null;
//
//    }
//
//    public ParticipantDTO toParticipantDTO(ParticipantVO participantVO) throws Exception {
//
//        if (participantVO == null) {
//            return null;
//        }
//
//        ParticipantDTO participantDTO = new ParticipantDTO();
//
//        participantDTO.setCpf_nr(participantVO.getCpf_nr());
//        participantDTO.setPrtcpnt_nm(participantVO.getPrtcpnt_nm());
//        participantDTO.setExt_code(participantVO.getExt_code());
//        participantDTO.setId_prtcpnt(participantVO.getId_prtcpnt());
//        participantDTO.setLast_accs(participantVO.getLast_accs());
//        participantDTO.setMobl_phon_nr(participantVO.getMobl_phon_nr());
//        participantDTO.setPep(participantVO.getPep());
//        participantDTO.setPhon_nr(participantVO.getPhon_nr());
//        participantDTO.setPrtcpnt_dsig(participantVO.getPrtcpnt_dsig());
//        participantDTO.setPrtcpnt_email(participantVO.getPrtcpnt_email());
//        participantDTO.setPrtcpnt_pfpj(participantVO.getPrtcpnt_pfpj());
//        participantDTO.setRg_nr(participantVO.getRg_nr());
//        participantDTO.setRgstrn_form_dt(participantVO.getRgstrn_form_dt());
//
//        return participantDTO;
//
//    }
//
//    public List<ParticipantDTO> toParticipantDTOList(Collection<ParticipantVO> participantVOS) throws Exception {
//
//        List<ParticipantDTO> participantDTOS = new ArrayList<ParticipantDTO>();
//
//        if (participantVOS != null && participantVOS.size() > 0) {
//
//            for (ParticipantVO participantVO : participantVOS) {
//
//                participantDTOS.add(toParticipantDTO(participantVO));
//
//            }
//
//        }
//
//        return participantDTOS;
//
//    }
//
//    public SignatureDTO toSignatureDTO(SignatureVO signatureVO) throws Exception {
//
//        if (signatureVO == null) {
//            return null;
//        }
//
//        SignatureDTO dto = new SignatureDTO();
//
//        dto.setCreatn_dt(signatureVO.getCreatn_dt());
//        dto.setEmail(signatureVO.getEmail());
//        dto.setEntityDTO(toEntityDTO(signatureVO.getEntity()));
//        dto.setParticipantDTO(toParticipantDTO(signatureVO.getParticipantVO()));
//        dto.setId_sgntr(signatureVO.getId_sgntr());
//        dto.setPosition_duty(toPositionDutyDTO(signatureVO.getPosition_duty()));
//        dto.setXpirtn_dt(signatureVO.getXpirtn_dt());
//
//        return dto;
//
//    }
//
//    public PositionDutyDTO toPositionDutyDTO(Position_DutyVO position_dutyVO) {
//
//        if (position_dutyVO == null) {
//            return null;
//        }
//
//        PositionDutyDTO dto = new PositionDutyDTO();
//        dto.setExt_code(position_dutyVO.getExt_code());
//        dto.setId_postn_duty(position_dutyVO.getId_postn_duty());
//        dto.setPostn_duty_nm(position_dutyVO.getPostn_duty_nm());
//
//        return dto;
//
//    }

}
