import { useNavigate } from "react-router-dom";
import { Card } from "../commons/cards";
import { useState } from "react";
import YearModel from "../../models/YearsModel";


interface Props {
	datas: YearModel[];
	addYear?: (year: string) => void;
};


export default function ListYears({
	datas, addYear
}: Props) {
	const navigate = useNavigate();
	const [isOpen, setIsOpen] = useState(false)


	return (
		<div className="flex flex-row flex-wrap items-stretch gap-4 p-4 py-10">
			{datas.map((option) => (
				<Card
					key={option.id}
					title={option.title}
					cardForm={false}
					navigateTo={() => navigate(`/dashboard/taskGroup/${option}`)}
				/>
			))}

			<Card
				cardForm={true}
				onAddClick={() => setIsOpen(true)}
				onSubmit={addYear}
				openForm={isOpen}
				showYearForm={true}
			/>
		</div>
	);
}