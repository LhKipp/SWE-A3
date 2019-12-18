package com.swe.janalyzer.util;

import java.nio.file.Path;
import java.util.Objects;

public class Options {
		private int loc;
		private int dit;
		private int cc;
		private int wmc;

		private String customPathName;
		private Path customPath;

		public int getLoc() {
				return loc;
		}

		public void setLoc(int loc) {
				this.loc = loc;
		}

		public int getDit() {
				return dit;
		}

		public void setDit(int dit) {
				this.dit = dit;
		}

		public int getCc() {
				return cc;
		}

		public void setCc(int cc) {
				this.cc = cc;
		}

		public int getWmc() {
				return wmc;
		}

		public void setWmc(int wmc) {
				this.wmc = wmc;
		}

		public String getCustomPathName() {
				return customPathName;
		}

		public Path getCustomPath() {
				return customPath;
		}

		public void setCustomPath(String customPathName, Path customPath) {
				this.customPathName = customPathName;
				this.customPath = customPath;
		}

		@Override
		public boolean equals(Object o){
				if (this == o) return true;
				if (o == null || getClass() != o.getClass()) return false;
				Options that = (Options) o;
				return loc == that.loc && dit == that.dit && cc == that.cc && wmc == that.wmc &&
						Objects.equals(customPathName, that.customPathName) &&
						Objects.equals(customPath, that.customPath);
		}

		@Override
		public int hashCode() {
				return Objects.hash(loc,dit,cc,wmc,customPathName,customPath);
		}
}
