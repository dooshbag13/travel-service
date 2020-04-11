package com.example.demo.app;

public enum Country {
	BULGARIA {
		@Override
		public Currency getCurrency() {
			return Currency.BGN;
		}
	},
	GREECE {
		@Override
		public Currency getCurrency() {
			return Currency.EUR;
		}
	},
	ALBANIA {
		@Override
		public Currency getCurrency() {
			return Currency.ALL;
		}
	},
	ROMANIA {
		@Override
		public Currency getCurrency() {
			return Currency.RON;
		}
	},
	SERBIA {
		@Override
		public Currency getCurrency() {
			return Currency.RSD;
		}
	},
	MACEDONIA {
		@Override
		public Currency getCurrency() {
			return Currency.MKD;
		}
	},
	TURKEY {
		@Override
		public Currency getCurrency() {
			return Currency.TRY;
		}
	};

	public abstract Currency getCurrency();
}
