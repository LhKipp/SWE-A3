package com.swe.janalyzer.data.metriken.cumulated;

public class CumulatedMetrics {
		private int locCummulated;
		private int ditCummulated;
		private int ccCummulated;
		private int wmcCummulated;

		public CumulatedMetrics() { }

		public CumulatedMetrics(int locCummulated, int ditCummulated, int ccCummulated, int wmcCummulated) {
				this.locCummulated = locCummulated;
				this.ditCummulated = ditCummulated;
				this.ccCummulated = ccCummulated;
				this.wmcCummulated = wmcCummulated;
		}

		public int getLocCummulated() {
				return locCummulated;
		}

		public void setLocCummulated(int locCummulated) {
				this.locCummulated = locCummulated;
		}

		public int getDitCummulated() {
				return ditCummulated;
		}

		public void setDitCummulated(int ditCummulated) {
				this.ditCummulated = ditCummulated;
		}

		public int getCcCummulated() {
				return ccCummulated;
		}

		public void setCcCummulated(int ccCummulated) {
				this.ccCummulated = ccCummulated;
		}

		public int getWmcCummulated() {
				return wmcCummulated;
		}

		public void setWmcCummulated(int wmcCummulated) {
				this.wmcCummulated = wmcCummulated;
		}
}
