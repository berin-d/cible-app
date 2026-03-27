
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import { faCirclePlus } from "@fortawesome/free-solid-svg-icons";

type Props = {
	onSelect: (year: string) => void;
};

export default function YearSelector({ onSelect }: Props) {
	const years = [...new Set(["2025", "2028", "2027", new Date().getFullYear().toString()])]
		.sort((a, b) => Number(a) - Number(b));

	return (
		<div>

			<div className="text-3xl font-bold tracking-tight md:text-4xl text-white">
				Dashboard
			</div>
			<div className="text-3xl text-[#71717a] mt-4">
				Select a timeframe to view nested objectives.
			</div>




			<div className="flex flex-row items-stretch gap-4 p-4 py-10">
				{years.map((year) => (
					<div
						key={year}
						onClick={() => onSelect(year)}
						className="relative flex flex-col bg-zinc-900 shadow-sm border border-slate-700 rounded-lg w-96 cursor-pointer hover:border-slate-500 transition-colors"					>
						<div className="p-4">
							<div className="flex justify-between items-start mb-8">
								<h5 className="text-white text-2xl font-semibold">
									{year}
								</h5>
								<span className="text-slate-400 text-sm">↗</span>
							</div>
							<div className="mb-1 flex justify-between items-center">
								<p className="text-slate-400 text-sm">Progress</p>
								<p className="text-slate-400 text-sm">64%</p>
							</div>
							<div className="w-full bg-slate-700 rounded-full h-1.5 mb-4">
								<div
									className="w-1/2 h-full bg-[#10B981] group-hover:bg-[#065F46] rounded-full transition-colors"
									style={{ width: "64%" }}
								/>
							</div>
							<p className="text-slate-400 text-sm">
								12 Active Groups + 142 Tasks
							</p>
						</div>
					</div>
				))}
				<div
					key={12}
					className="relative flex flex-col items-center justify-center py-8 bg-zinc-900 shadow-sm border border-dashed border-slate-700 rounded-lg w-96 cursor-pointer hover:border-slate-500 transition-colors group"
				>
					<FontAwesomeIcon
						icon={faCirclePlus}
						className="text-3xl mb-3 text-slate-700 group-hover:text-slate-500 transition-colors"
					/>
					<div className="text-slate-700 font-medium group-hover:text-slate-500 transition-colors">
						Add Year
					</div>
				</div>
			</div>
		</div>

	);
}