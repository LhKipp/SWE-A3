package com.swe.janalyzer.data.metriken.cumulative;

import com.swe.janalyzer.data.metriken.Summary;

/**
 * Datenmodell für die kumulierten Metriken.
 * {@link CumulatedMetrics#cumCc} ist der kumulierte Wert des MacCabes für ein Projekt.
 * {@link CumulatedMetrics#cumWmc} ist der kumulierte Wert des WMC für ein Projekt.
 * {@link CumulatedMetrics#cumLoc} ist der kumulierte Wert des LOC für ein Projekt.
 * {@link CumulatedMetrics#cumDit} ist der kumulierte Wert des DIT für ein Projekt
 */
public class CumulatedMetrics implements Cumulate{
		private int cumLoc;
		private int cumWmc;
		private int cumCc;
		private int cumDit;

		/**
		 * Standardkonstrukor; initialisiert alle Werte mit 0.
		 */
		public CumulatedMetrics() {
				cumLoc = 0;
				cumWmc = 0;
				cumCc = 0;
				cumDit = 0;
		}

		/**
		 * Kumuliert die Werte einer übergebenen Summary.
		 * @param summary
		 */
		@Override
		public void cumulateMetrics(Summary summary) {
				//Werte aus Summary kumulieren...
		}

		/**
		 * Getter für {@link CumulatedMetrics#cumLoc}.
		 * @return
		 */
		public int getLoc () {
				return this.cumLoc;
		}

		/**
		 * Getter für {@link CumulatedMetrics#cumWmc}.
		 * @return
		 */
		public int getWmc () {
				return this.cumWmc;
		}

		/**
		 * Getter für {@link CumulatedMetrics#cumCc}.
		 * @return
		 */
		public int getCc () {
				return this.cumCc;
		}

		/**
		 * Getter für {@link CumulatedMetrics#cumDit}.
		 * @return
		 */
		public int getDit () {
				return this.cumDit;
		}
}
