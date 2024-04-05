package com.ezen.mall.web.common.page;

/**
 * 페이징 처리 계산
 * @author 김기정
 */
public class Pagination {
	
	// 페이징 계산에 필요한 속성
	private PageParams params;        /** 여러개의 파라메터 저장 */

	// 계산 결과 저장을 위한 필드
	private int totalPages;           /** 전체 페이지 수 */
	private int listNo;               /** 목록별 식별번호 */
	private int startPage;            /** 현재 페이지가 소속된 목록의 시작 번호 */
	private int endPage;              /** 현재 페이지가 소속된 목록의 마지막 번호 */
	private int previousStartPage;    /** 이전 페이지가 소속된 목록의 시작 번호 */
	private int nextStartPage;        /** 다음 페이지가 소속된 목록의 마지막 번호 */
	
	public Pagination(PageParams params) {
		this.params = params;
		calculate();
	}
	
	public PageParams getParams() {
		return params;
	}

	public void setParams(PageParams params) {
		this.params = params;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}

	public int getListNo() {
		return listNo;
	}

	public void setListNo(int listNo) {
		this.listNo = listNo;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getPreviousStartPage() {
		return previousStartPage;
	}

	public void setPreviousStartPage(int previousStartPage) {
		this.previousStartPage = previousStartPage;
	}

	public int getNextStartPage() {
		return nextStartPage;
	}

	public void setNextStartPage(int nextStartPage) {
		this.nextStartPage = nextStartPage;
	}
	
	@Override
	public String toString() {
		return "Pagination [params=" + params + ", totalPages=" + totalPages + ", listNo=" + listNo + ", startPage="
				+ startPage + ", endPage=" + endPage + ", previousStartPage=" + previousStartPage + ", nextStartPage="
				+ nextStartPage + "]";
	}

	/** 페이징 계산 */
	public void calculate(){
		// 테이블로부터 검색된 행의 수에 따른 전체페이지수 계산
		totalPages = (int)Math.ceil((double)params.getRowCount() / params.getElementSize());
		
		// 목록별 번호(1~10):0, (11~20):1, (21~30):2, .....
		listNo = (params.getRequestPage() - 1) / params.getPageSize();
			
		// 현재 페이지의 시작페이지번호와 마지막페이지번호 계산
		startPage = (listNo * params.getPageSize()) + 1;
		endPage = (listNo * params.getPageSize()) + params.getPageSize();
		if (endPage > totalPages){
			endPage = totalPages;
		}
		
		// 이전 그룹의 시작페이지 번호 계산
		previousStartPage = startPage - params.getPageSize();
		// 첫번째 목록인 경우 1페이지로 설정
		if (previousStartPage < 0)  previousStartPage = 1;
		
		// 다음 목록의 시작페이지 번호 계산
		nextStartPage = startPage + params.getPageSize();
	}
	
	/** 현재 목록에서 [처음으로] 출력 여부 반환 */
	public boolean isShowFirst() {
		return listNo > 0;
	}
	
	/** 현재 목록에서 [끝으로] 출력 여부 반환 */
	public boolean isShowLast() {
		return endPage < totalPages;
	}
	
	/** 현재 목록에서 [이전목록] 출력 여부 반환 */
	public boolean isShowPrevious() {
		return listNo > 0;
	}
	
	/** 현재 목록에서 [다음목록] 출력 여부 반환 */
	public boolean isShowNext() {
		return endPage < totalPages;
	}
	
	
	/** 테스트을 위한 main */
	public static void main(String[] args) {
		PageParams params = new PageParams(15, 5, 25, 2048);
		Pagination pagination = new Pagination(params);
		
		System.out.println("테이블에서 검색된 행의수: " + params.getRowCount());
		System.out.println("사용자 요청페이지: " + params.getRequestPage());
		System.out.println("계산된 전체페이지수: " + pagination.getTotalPages());
		
		System.out.println("계산된 현재목록의 시작페이지 번호: " + pagination.getStartPage());
		System.out.println("계산된 현재목록의 끝페이지 번호: " + pagination.getEndPage());
		
		System.out.println("처음으로 보여주기 여부: " + pagination.isShowFirst());
		System.out.println("이전목록 보여주기 여부: " + pagination.isShowPrevious());
		
		System.out.println("다음목록 보여주기 여부: " + pagination.isShowNext());
		System.out.println("끝으로 보여주기 여부: " + pagination.isShowLast());
		
		// JSP에서 페이징 처리 시
		if(pagination.isShowFirst()) {
			System.out.print("처음으로 ");
		}
		
		if(pagination.isShowPrevious()) {
			System.out.print("이전목록 ");
		}
				
		for(int i=pagination.getStartPage(); i<=pagination.getEndPage(); i++){
			System.out.print(i + " ");
		}
		
		if(pagination.isShowNext()) {
			System.out.print("다음목록 ");
		}
		
		if(pagination.isShowLast()) {
			System.out.print("끝으로 ");
		}
		System.out.println();
		
	}
}
