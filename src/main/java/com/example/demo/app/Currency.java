package com.example.demo.app;

public enum Currency {
	BGN {
		private final float localToEuroRate = 1.96f;

		@Override
		public float getEuroAmount(float localValue) {
			return localValue / localToEuroRate;
		}

		@Override
		public float getLocalAmount(float euroValue) {
			return euroValue * localToEuroRate;
		}
	},
	EUR {
		private final float localToEuroRate = 1;

		@Override
		public float getEuroAmount(float localValue) {
			return localValue / localToEuroRate;
		}

		@Override
		public float getLocalAmount(float euroValue) {
			return euroValue * localToEuroRate;
		}
	},
	ALL {
		private final float localToEuroRate = 31.14f;

		@Override
		public float getEuroAmount(float localValue) {
			return localValue / localToEuroRate;
		}

		@Override
		public float getLocalAmount(float euroValue) {
			return euroValue * localToEuroRate;
		}
	},
	TRY {
		private final float localToEuroRate = 12.7f;

		@Override
		public float getEuroAmount(float localValue) {
			return localValue / localToEuroRate;
		}

		@Override
		public float getLocalAmount(float euroValue) {
			return euroValue * localToEuroRate;
		}
	},
	RSD {
		private final float localToEuroRate = 72.3f;

		@Override
		public float getEuroAmount(float localValue) {
			return localValue / localToEuroRate;
		}

		@Override
		public float getLocalAmount(float euroValue) {
			return euroValue * localToEuroRate;
		}
	},
	RON {
		private final float localToEuroRate = 41.8f;

		@Override
		public float getEuroAmount(float localValue) {
			return localValue / localToEuroRate;
		}

		@Override
		public float getLocalAmount(float euroValue) {
			return euroValue * localToEuroRate;
		}
	},
	MKD {
		private final float localToEuroRate = 82.6f;

		@Override
		public float getEuroAmount(float localValue) {
			return localValue / localToEuroRate;
		}

		@Override
		public float getLocalAmount(float euroValue) {
			return euroValue * localToEuroRate;
		}
	};

	public abstract float getEuroAmount(float localValue);
	public abstract float getLocalAmount(float euroValue);
}
