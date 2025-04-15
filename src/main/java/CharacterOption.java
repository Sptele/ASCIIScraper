public enum CharacterOption {
	FULL, FITTED, SMUSH_R {
		@Override
		public String toString() {
			return "SMUSH (R)";
		}
	}, SMUSH_U {
		@Override
		public String toString() {
			return "SMUSH (U)";
		}
	}, DEFAULT
}
