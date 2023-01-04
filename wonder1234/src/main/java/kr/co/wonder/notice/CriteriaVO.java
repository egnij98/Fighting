package kr.co.wonder.notice;

public class CriteriaVO {

		private int page;
		private int perPageNum;
		private String notice_sort;
		
		public String getNotice_sort() {
			return notice_sort;
		}

		public void setNotice_sort(String notice_sort) {
			this.notice_sort = notice_sort;
		}

		public CriteriaVO() {
			
			this.page = 1;
			this.perPageNum = 10;
			
		}

		public int getPage() {
			return page;
		}

		public void setPage(int page) {
			if(page<=0) {
				this.page = 1;
				return;
			}
			this.page = page;
		}

		public int getPerPageNum() {
			return perPageNum;
		}

		public void setPerPageNum(int perPageNum) {
			if(perPageNum <=0 || perPageNum >100) {
				this.perPageNum = 10;
				return;
			}
			this.perPageNum = perPageNum;
		}
		public int getPageStart() {
			return(this.page -1 )* perPageNum;
		}

		@Override
		public String toString() {
			return "CriteriaVO [page=" + page + ", perPageNum=" + perPageNum + "]";
		}

		
}
