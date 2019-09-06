package aoyama.member.api.search;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import aoyama.member.domain.service.MemberInfoApiService;
import aoyama.member.domain.service.NonMemberInfoApiService;
import aoyama.member.domain.common.CommonUtil;
import aoyama.member.domain.model.MemberInfo;
import aoyama.member.domain.model.MemberName;
import aoyama.member.domain.model.NonMemberDataReqBean;
import aoyama.member.domain.model.NonMemberDataResBean;
import aoyama.member.domain.model.NonMemberDataResListBean;

@RestController
public class SearchMemberNameRestController {
    
    @Autowired
    private MemberInfoApiService memberService;

    @Autowired
    private NonMemberInfoApiService nonMemberService;

    @Autowired
    MessageSource messageSource;
    
    private static final Logger logger = LoggerFactory
            .getLogger(SearchMemberNameRestController.class);

    @RequestMapping(value="memname", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getMemberInfo(@RequestParam("kokNo") String kokno, @RequestParam("gyotaiCd") String gyotaiCd) {
        
        if (CommonUtil.isEmpty(kokno)) {
            return null;
        }
        
        MemberName bean = null;
        try {
            // 会員の場合
            if (kokno.charAt(0) == '6') {
                // 顧客番号＋業態コードで会員検索
                MemberInfo memberInfo = memberService.getMemberInfo(kokno, gyotaiCd);
                if (memberInfo != null) {
                    // レスポンスをbeanに詰めなおす
                    bean = new MemberName();
                    bean.setFirstName(memberInfo.getFirstName());
                    bean.setFirstNameKana(memberInfo.getFirstNameKana());
                    bean.setLastName(memberInfo.getLastName());
                    bean.setLastNameKana(memberInfo.getLastNameKana());               
                }
            // 非会員の場合
            } else if (kokno.charAt(0) == '7') {
                NonMemberDataReqBean reqBean = new NonMemberDataReqBean();
                // 顧客番号＋業態コードで非会員検索
                reqBean.setKokNo(Long.parseLong(kokno));
                reqBean.setGyotai(Integer.parseInt(gyotaiCd));
                NonMemberDataResBean resBean = nonMemberService.getNonMemberInfo(reqBean);
                if ((resBean!= null) && (resBean.getNonMemberDataResponse() != null)) {
                    List<NonMemberDataResListBean> nonMemberDataResponse = resBean.getNonMemberDataResponse();
                    if (0 < nonMemberDataResponse.size()) {
                        // 1件目のレスポンスをbeanに詰めなおす
                        NonMemberDataResListBean nonMemberDataResListBean = nonMemberDataResponse.get(0);
                        bean = new MemberName();
                        bean.setFirstName(nonMemberDataResListBean.getSeij());
                        bean.setFirstNameKana(nonMemberDataResListBean.getSei());
                        bean.setLastName(nonMemberDataResListBean.getMeij());
                        bean.setLastNameKana(nonMemberDataResListBean.getMei());               
                    }
                }
            }

            // WEB-API連携用の平文を返却
            return MemberName.toPlainText(bean);
        } catch(Exception e) {
            logger.error(e.getMessage());
            return null;
        }
    }
}
