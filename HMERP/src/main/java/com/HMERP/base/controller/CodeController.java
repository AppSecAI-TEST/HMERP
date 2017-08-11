package com.HMERP.base.controller;


@Controller
public class CodeController {
	/* BaseServiceFacade setting */
	@Autowired
	private BaseServiceFacade baseServiceFacade;
	@Autowired
	private DatasetBeanMapper datasetBeanMapper;
	
	@RequestMapping("base/findCodeList.do")
	public void findCodeList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformData outData = (PlatformData) request.getAttribute("outData");
		List<CodeBean> codeList = baseServiceFacade.findCodeList();
		List<DetailCodeBean> detailCodeList = new ArrayList<DetailCodeBean>();
		for (CodeBean codeBean : codeList) {
			List<DetailCodeBean> detailCodeBeanList = codeBean.getDetailCodeList();

			detailCodeList.addAll(detailCodeBeanList);
		}
		datasetBeanMapper.beansToDataset(outData, codeList, CodeBean.class);
		datasetBeanMapper.beansToDataset(outData, detailCodeList, DetailCodeBean.class);
	}
	
	@RequestMapping("base/batchCode.do")
	public void batchCode(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PlatformData inData = (PlatformData) request.getAttribute("inData");
		CodeInfoBean codeInfoBean = new CodeInfoBean();
		codeInfoBean.setCodeList(datasetBeanMapper.datasetToBeans(inData, CodeBean.class));
		codeInfoBean.setDetailCodeList(datasetBeanMapper.datasetToBeans(inData, DetailCodeBean.class));
		baseServiceFacade.batchCode(codeInfoBean);
 d
		findCodeList(request, response);
	}
}
